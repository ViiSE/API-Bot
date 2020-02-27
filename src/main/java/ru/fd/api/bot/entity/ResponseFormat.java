package ru.fd.api.bot.entity;

public interface ResponseFormat<T> {
   T format(Response response);
}
