package ru.fd.api.bot.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.RequestPojo;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Requests;
import ru.fd.api.bot.producer.entity.RequestsProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

import java.util.ArrayList;
import java.util.List;

@Service("requestsCreatorDefault")
@Scope("prototype")
public class RequestsCreatorDefaultImpl implements RequestsCreator {

    private final CreatorService creatorService;
    private final RequestsProducer requestsProducer;
    private final PrinterProducer printerProducer;
    private final SettingsPojo settingsPojo;
    private final DateFormatter dateFormatter;

    public RequestsCreatorDefaultImpl(
            CreatorService creatorService,
            RequestsProducer requestsProducer,
            PrinterProducer printerProducer,
            SettingsPojo settingsPojo,
            DateFormatter dateFormatter) {
        this.creatorService = creatorService;
        this.requestsProducer = requestsProducer;
        this.printerProducer = printerProducer;
        this.settingsPojo = settingsPojo;
        this.dateFormatter = dateFormatter;
    }

    @Override
    public Requests create() {
        List<Request> requestList = new ArrayList<>();
        for(RequestPojo requestP: settingsPojo.getRequests()) {
            if(requestP.getAuth() == null && settingsPojo.getAuth() == null)
                throw new RuntimeException("Auth field not found! Add auth field to the root of settings file or " +
                        "add auth field to each request.");

            if(requestP.getAuth() == null) {
                requestList.add(
                        creatorService.getPrintableRequestCreatorInstance(
                                creatorService.getBenchmarkRequestCreatorInstance(
                                        creatorService.getGetRequestCreatorDefaultInstance(
                                                requestP,
                                                settingsPojo.getAuth(),
                                                settingsPojo.getHostname())),
                                printerProducer,
                                dateFormatter,
                                settingsPojo.getFilename())
                                .create());
            } else {
                requestList.add(
                        creatorService.getPrintableRequestCreatorInstance(
                                creatorService.getBenchmarkRequestCreatorInstance(
                                        creatorService.getRequestCreatorWithAuthInstance(
                                                requestP,
                                                settingsPojo.getHostname())),
                                printerProducer,
                                dateFormatter,
                                settingsPojo.getFilename())
                                .create());
            }
        }

        return requestsProducer.getRequestsDefaultInstance(requestList);
    }
}
