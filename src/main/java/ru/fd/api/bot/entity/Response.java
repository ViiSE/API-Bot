package ru.fd.api.bot.entity;

public interface Response {
    String method();
    String url();
    long evaluateTime();
}
