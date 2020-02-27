package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;

@Component("getResponseWithUrl")
@Scope("prototype")
public class GetResponseWithUrlImpl implements Response {

    private final String url;

    public GetResponseWithUrlImpl(String url) {
        this.url = url;
    }

    @Override
    public String method() {
        return Methods.GET;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public long evaluateTime() {
        return 0;
    }
}
