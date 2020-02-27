package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;

@Component("deleteResponseWithUrl")
@Scope("prototype")
public class DeleteResponseWithUrlImpl implements Response {

    private final String url;

    public DeleteResponseWithUrlImpl(String url) {
        this.url = url;
    }

    @Override
    public String method() {
        return Methods.DELETE;
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
