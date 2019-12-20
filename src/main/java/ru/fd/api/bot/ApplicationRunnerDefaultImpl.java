package ru.fd.api.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.BotExecutorProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

@Component("applicationRunnerDefault")
@Scope("prototype")
public class ApplicationRunnerDefaultImpl implements ApplicationRunner {

    @Autowired private CreatorService creatorService;
    @Autowired private BotExecutorProducer botExecutorProducer;
    @Autowired private DateFormatter dateFormatter;

    private final SettingsFile<String> settingsFile;

    public ApplicationRunnerDefaultImpl(SettingsFile<String> settingsFile) {
        this.settingsFile = settingsFile;
    }

    @Override
    public void run() {
        botExecutorProducer.getBotExecutorDefaultInstance(
                creatorService.getSettingsCreatorFromFileInstance(settingsFile, dateFormatter)
                        .create())
                .startBot();
    }
}
