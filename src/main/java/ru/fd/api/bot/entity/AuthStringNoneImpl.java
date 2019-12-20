package ru.fd.api.bot.entity;

import org.springframework.stereotype.Component;

@Component("authStringNone")
public class AuthStringNoneImpl implements Auth<String> {

    @Override
    public String body() { return ""; }
}
