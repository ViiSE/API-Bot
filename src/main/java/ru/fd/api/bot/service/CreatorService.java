package ru.fd.api.bot.service;

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

public interface CreatorService {
    RequestCreator<Map<String, Object>> getRequestCreatorWithAuthInstance(RequestPojo request, String hostname);
    RequestCreator<Map<String, Object>> getGetRequestCreatorDefaultInstance(RequestPojo request, AuthPojo auth, String hostname);
    RequestCreator<Map<String, Object>> getBenchmarkRequestCreatorInstance(RequestCreator<Map<String, Object>> requestCreator);
    RequestCreator<Map<String, Object>> getPrintableRequestCreatorInstance(RequestCreator<Map<String, Object>> requestCreator, PrinterProducer printerProducer, DateFormatter dateFormatter, String fullFilename);
    RequestsCreator getRequestsCreatorDefaultInstance(SettingsPojo settingsPojo, DateFormatter dateFormatter);
    AuthCreator getAuthCreatorDefaultInstance(AuthPojo auth);
    SettingsCreator getSettingsCreatorFromFileInstance(SettingsFile<String> settingsFile, DateFormatter dateFormatter);
}
