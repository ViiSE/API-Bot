package ru.fd.api.bot.entity;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;

@Component("emptyResponse")
public class EmptyResponseImpl implements Response {

    @Override
    public String method() {
        return Methods.NONE;
    }

    @Override
    public String url() {
        return "empty";
    }

    @Override
    public long evaluateTime() {
        return 0;
    }
}
