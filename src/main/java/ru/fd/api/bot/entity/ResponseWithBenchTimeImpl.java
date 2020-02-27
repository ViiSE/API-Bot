package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("responseWithBenchTime")
@Scope("prototype")
public class ResponseWithBenchTimeImpl implements Response {

    private final Response response;
    private final long evaluateTime;

    public ResponseWithBenchTimeImpl(Response response, long evaluateTime) {
        this.response = response;
        this.evaluateTime = evaluateTime;
    }

    @Override
    public String method() {
        return response.method();
    }

    @Override
    public String url() {
        return response.url();
    }

    @Override
    public long evaluateTime() {
        return evaluateTime;
    }
}
