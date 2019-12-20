package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("settingsDefault")
@Scope("prototype")
public class SettingsDefaultImpl implements Settings {

    private final Requests requests;
    private final int repeat;
    private final String fullFilename;

    public SettingsDefaultImpl(Requests requests, int repeat, String fullFilename) {
        this.requests = requests;
        this.repeat = repeat;
        this.fullFilename = fullFilename;
    }


    @Override
    public Requests requests() {
        return requests;
    }

    @Override
    public int repeat() {
        return repeat;
    }

    @Override
    public String fullFilename() {
        return fullFilename;
    }
}
