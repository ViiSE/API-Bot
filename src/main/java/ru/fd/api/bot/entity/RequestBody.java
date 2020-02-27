package ru.fd.api.bot.entity;

import java.util.List;

public interface RequestBody<T> {
    List<T> requestBodyParams();
}
