package ru.fd.api.bot;

import ru.fd.api.bot.file.SettingsFile;

public interface ApplicationRunner<T> {
    void run(SettingsFile<T> settingsFile);
}
