package ru.fd.api.bot.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.constant.Auths;
import ru.fd.api.bot.constant.Methods;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.AuthProducer;
import ru.fd.api.bot.producer.entity.RequestBodyProducer;
import ru.fd.api.bot.producer.entity.RequestProducer;
import ru.fd.api.bot.producer.entity.ResponseProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("settingsFromFileJson")
@Scope("prototype")
public class SettingsFromFileJsonImpl implements Settings<Request> {

    private final List<Request> requests = new ArrayList<>();
    private final RequestProducer requestProducer;
    private final AuthProducer authProducer;
    private final ResponseProducer responseProducer;
    private final RequestBodyProducer requestBodyProducer;
    private final SettingsFile<String> settingsFile;

    private int repeat;
    private String fullFilename = "";

    public SettingsFromFileJsonImpl(
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsFile<String> settingsFile) {
        this.requestProducer = requestProducer;
        this.authProducer = authProducer;
        this.responseProducer = responseProducer;
        this.requestBodyProducer = requestBodyProducer;
        this.settingsFile = settingsFile;
    }

    @Override
    public List<Request> requests() {
        if(requests.isEmpty())
            init();
        return requests;
    }

    @Override
    public int repeat() {
        if(repeat == 0)
            init();
        return repeat;
    }

    @Override
    public String fullFilename() {
        if(fullFilename.isEmpty())
            init();
        return fullFilename;
    }

    private void init() {
        try {
            String json = settingsFile.content();
            SettingsPojo settingsPojo = new ObjectMapper().readValue(json, SettingsPojo.class);

            requests.addAll(settingsPojo.getRequests()
                    .stream()
                    .map(requestPojo -> {
                        String uri = String.join("", settingsPojo.getHostname(), requestPojo.getUrl());
                        Auth<String> auth;

                        if(requestPojo.getAuth() == null) {
                            if (settingsPojo.getAuth() == null)
                                throw new RuntimeException("Auth field not found! Add auth field to the root of settings file or " +
                                        "add auth field to each request.");

                            if(settingsPojo.getAuth().getType().equals(Auths.NONE))
                                auth = authProducer.getAuthStringNoneInstance();
                            else
                                auth = authProducer.getAuthStringTokenInstance(
                                        settingsPojo.getAuth().getType(),
                                        settingsPojo.getAuth().getToken());

                        } else {
                            if(settingsPojo.getAuth().getType().equals(Auths.NONE))
                                auth = authProducer.getAuthStringNoneInstance();
                            else
                                auth = authProducer.getAuthStringTokenInstance(
                                        requestPojo.getAuth().getType(),
                                        requestPojo.getAuth().getToken());
                        }

                        Request request;

                        switch (requestPojo.getMethod()) {
                            case Methods.GET:
                                request = requestProducer.getGetRequestInstance(
                                        uri,
                                        auth,
                                        responseProducer);
                                break;
                            case Methods.POST:
                                request = requestProducer.getPostRequestInstance(
                                        uri,
                                        auth,
                                        requestBodyProducer.getRequestBodyWithListParamsInstance(requestPojo.getBody()),
                                        responseProducer);
                                break;
                            case Methods.PUT:
                                request = requestProducer.getPutRequestInstance(
                                        uri,
                                        auth,
                                        requestBodyProducer.getRequestBodyWithListParamsInstance(requestPojo.getBody()),
                                        responseProducer);
                                break;
                            case Methods.DELETE:
                                request = requestProducer.getDeleteRequestInstance(
                                        uri,
                                        auth,
                                        requestBodyProducer.getRequestBodyWithListParamsInstance(requestPojo.getBody()),
                                        responseProducer);
                                break;
                            default:
                                request = requestProducer.getEmptyRequestInstance();
                                break;
                        }

                        return requestProducer.getRequestWithBenchInstance(request, responseProducer);
                    }).collect(Collectors.toList()));
            repeat = settingsPojo.getRepeat();
            fullFilename = settingsPojo.getFilename();
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
