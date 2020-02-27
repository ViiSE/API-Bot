package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.data.RequestBodyPojo;

import java.util.List;

@Component("requestBodyWithListParams")
@Scope("prototype")
public class RequestBodyWithListParamsImpl implements RequestBody<RequestBodyPojo> {

    private final List<RequestBodyPojo> params;

    public RequestBodyWithListParamsImpl(List<RequestBodyPojo> params) {
        this.params = params;
    }

    @Override
    public List<RequestBodyPojo> requestBodyParams() {
        return params;
    }
}
