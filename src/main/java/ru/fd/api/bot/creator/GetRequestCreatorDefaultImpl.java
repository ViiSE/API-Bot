package ru.fd.api.bot.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.data.RequestPojo;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.producer.entity.RequestProducer;
import ru.fd.api.bot.producer.entity.RequestResultProducer;
import ru.fd.api.bot.service.CreatorService;

import java.util.Map;

@Service("getRequestCreatorDefault")
@Scope("prototype")
public class GetRequestCreatorDefaultImpl implements RequestCreator<Map<String, Object>> {

    private final CreatorService creatorService;
    private final RequestProducer requestProducer;
    private final RequestResultProducer requestResultProducer;
    private final RequestPojo request;
    private final AuthPojo auth;
    private final String hostname;

    public GetRequestCreatorDefaultImpl(
            CreatorService creatorService,
            RequestProducer requestProducer,
            RequestResultProducer requestResultProducer,
            RequestPojo request,
            AuthPojo auth,
            String hostname) {
        this.creatorService = creatorService;
        this.requestProducer = requestProducer;
        this.requestResultProducer = requestResultProducer;
        this.request = request;
        this.auth = auth;
        this.hostname = hostname;
    }

    @Override
    public Request<Map<String, Object>> create() {
        return requestProducer.getGetRequestDefaultInstance(
                request.getMethod(),
                String.join("", hostname, request.getUrl()),
                creatorService.getAuthCreatorDefaultInstance(auth).create(),
                requestResultProducer);
    }
}
