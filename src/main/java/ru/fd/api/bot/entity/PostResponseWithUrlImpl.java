package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;

@Component("postResponseWithUrl")
@Scope("prototype")
public class PostResponseWithUrlImpl implements Response {

    private final String url;

    public PostResponseWithUrlImpl(String url) {
        this.url = url;
    }

    @Override
    public String method() {
        return Methods.POST;
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
