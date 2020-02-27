package ru.fd.api.bot.entity;

import java.util.List;

public interface Settings<T> {
    List<T> requests();
    int repeat();
    String fullFilename();
}
