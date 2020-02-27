package ru.fd.api.bot.entity;

import ru.fd.api.bot.exception.RequestException;

public interface Request {
    Response execute() throws RequestException;
}
