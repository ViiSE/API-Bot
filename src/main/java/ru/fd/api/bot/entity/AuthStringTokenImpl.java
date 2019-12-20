package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("authStringToken")
@Scope("prototype")
public class AuthStringTokenImpl implements Auth<String> {

    private final String type;
    private final String token;

    public AuthStringTokenImpl(String type, String token) {
        this.type = type;
        this.token = token;
    }

    @Override
    public String body() {
        return type + " " + token;
    }
}
