package ru.fd.api.bot.entity;

import ru.fd.api.bot.exception.RequestException;

public interface Request<T> {
    RequestResult<T> execute() throws RequestException;
}
