package ru.fd.api.bot.entity;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Auths;

@Component("authStringNone")
public class AuthStringNoneImpl implements Auth<String> {

    @Override
    public String body() { return Auths.NONE; }
}
