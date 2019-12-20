package ru.fd.api.bot.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.entity.Requests;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.SettingsProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

@Service("settingsCreatorFromFileJson")
@Scope("prototype")
public class SettingsCreatorFromFileJsonImpl implements SettingsCreator {

    private final CreatorService creatorService;
    private final SettingsProducer settingsProducer;
    private final SettingsFile<String> settingsFile;
    private final DateFormatter dateFormatter;

    public SettingsCreatorFromFileJsonImpl(
            CreatorService creatorService,
            SettingsProducer settingsProducer,
            SettingsFile<String> settingsFile,
            DateFormatter dateFormatter) {
        this.creatorService = creatorService;
        this.settingsProducer = settingsProducer;
        this.settingsFile = settingsFile;
        this.dateFormatter = dateFormatter;
    }

    @Override
    public Settings create() {
        try {
            String json = settingsFile.content();
            SettingsPojo settingsPojo = new ObjectMapper().readValue(json, SettingsPojo.class);

            Requests requests = creatorService.getRequestsCreatorDefaultInstance(settingsPojo, dateFormatter).create();
            int repeat = settingsPojo.getRepeat();
            String fullFilename = settingsPojo.getFilename();

            return settingsProducer.getSettingsDefaultInstance(requests, repeat, fullFilename);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
