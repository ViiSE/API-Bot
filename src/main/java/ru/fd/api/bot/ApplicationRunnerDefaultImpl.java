package ru.fd.api.bot;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.*;

@Component("applicationRunnerDefault")
public class ApplicationRunnerDefaultImpl implements ApplicationRunner<String> {

    private final Bot bot;
    private final RequestProducer requestProducer;
    private final AuthProducer authProducer;
    private final ResponseProducer responseProducer;
    private final RequestBodyProducer requestBodyProducer;
    private final SettingsProducer settingsProducer;

    public ApplicationRunnerDefaultImpl(
            Bot bot,
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsProducer settingsProducer) {
        this.bot = bot;
        this.requestProducer = requestProducer;
        this.authProducer = authProducer;
        this.responseProducer = responseProducer;
        this.requestBodyProducer = requestBodyProducer;
        this.settingsProducer = settingsProducer;
    }

    @Override
    public void run(SettingsFile<String> settingsFile) {
        Settings<Request> settings = settingsProducer.getSettingsFromFileJsonInstance(
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                settingsFile);

        bot.execute(settings);
    }
}
