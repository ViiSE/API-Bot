package ru.fd.api.bot;

import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;

public interface Bot {
    void execute(Settings<Request> settings);
}
