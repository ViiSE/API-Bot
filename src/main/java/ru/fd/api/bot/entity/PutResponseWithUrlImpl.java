package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;

@Component("putResponseWithUrl")
@Scope("prototype")
public class PutResponseWithUrlImpl implements Response {

    private final String url;

    public PutResponseWithUrlImpl(String url) {
        this.url = url;
    }

    @Override
    public String method() {
        return Methods.PUT;
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
