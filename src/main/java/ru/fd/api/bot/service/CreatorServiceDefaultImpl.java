package ru.fd.api.bot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.creator.AuthCreator;
import ru.fd.api.bot.creator.RequestCreator;
import ru.fd.api.bot.creator.RequestsCreator;
import ru.fd.api.bot.creator.SettingsCreator;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.data.RequestPojo;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Service("creatorServiceDefault")
@Scope("prototype")
public class CreatorServiceDefaultImpl implements CreatorService {

    private final CreatorProducerService creatorProducerService;
    private final EntityProducerService entityProducerService;
    private final PrinterProducerService printerProducerService;

    public CreatorServiceDefaultImpl(
            CreatorProducerService creatorProducerService,
            EntityProducerService entityProducerService,
            PrinterProducerService printerProducerService) {
        this.creatorProducerService = creatorProducerService;
        this.entityProducerService = entityProducerService;
        this.printerProducerService = printerProducerService;
    }

    @Override
    public RequestCreator<Map<String, Object>> getRequestCreatorWithAuthInstance(RequestPojo request, String hostname) {
        return creatorProducerService
                .requestCreatorProducer()
                .getRequestCreatorWithAuthInstance(
                        this,
                        entityProducerService.requestProducer(),
                        entityProducerService.requestResultProducer(),
                        request,
                        hostname);
    }

    @Override
    public RequestCreator<Map<String, Object>> getGetRequestCreatorDefaultInstance(
            RequestPojo request, AuthPojo auth, String hostname) {
        return creatorProducerService
                .requestCreatorProducer()
                .getGetRequestCreatorDefaultInstance(
                        this,
                        entityProducerService.requestProducer(),
                        entityProducerService.requestResultProducer(),
                        request,
                        auth,
                        hostname);
    }

    @Override
    public RequestCreator<Map<String, Object>> getBenchmarkRequestCreatorInstance(
            RequestCreator<Map<String, Object>> requestCreator) {
        return creatorProducerService.requestCreatorProducer()
                .getBenchmarkRequestCreatorInstance(
                        entityProducerService.requestProducer(),
                        requestCreator);
    }

    @Override
    public RequestCreator<Map<String, Object>> getPrintableRequestCreatorInstance(
            RequestCreator<Map<String, Object>> requestCreator,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename) {
        return creatorProducerService.requestCreatorProducer()
                .getPrintableRequestCreatorInstance(
                        entityProducerService.requestProducer(),
                        requestCreator,
                        printerProducer,
                        dateFormatter,
                        fullFilename);
    }

    @Override
    public RequestsCreator getRequestsCreatorDefaultInstance(SettingsPojo settings, DateFormatter dateFormatter) {
        return creatorProducerService
                .requestsCreatorProducer()
                .getRequestsCreatorDefaultInstance(
                        this,
                        entityProducerService.requestsProducer(),
                        printerProducerService.printerProducer(),
                        settings,
                        dateFormatter);
    }

    @Override
    public AuthCreator getAuthCreatorDefaultInstance(AuthPojo auth) {
        return creatorProducerService
                .authCreatorProducer()
                .getAuthCreatorDefaultInstance(auth, entityProducerService.authProducer());
    }

    @Override
    public SettingsCreator getSettingsCreatorFromFileInstance(SettingsFile<String> settingsFile, DateFormatter dateFormatter) {
        return creatorProducerService
                .settingsCreatorProducer()
                .getSettingsCreatorFromFileJsonInstance(
                        this,
                        entityProducerService.settingsProducer(),
                        settingsFile,
                        dateFormatter);
    }
}
