package ru.fd.api.bot.producer.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.RequestBody;
import ru.fd.api.bot.entity.RequestBodyWithListParamsImpl;

import java.util.List;

@Service("requestBodyProducerDefault")
public class RequestBodyProducerDefaultImpl implements RequestBodyProducer {

    private final ApplicationContext ctx;

    public RequestBodyProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public RequestBody<RequestBodyPojo> getRequestBodyWithListParamsInstance(List<RequestBodyPojo> params) {
        return (RequestBodyWithListParamsImpl) ctx.getBean("requestBodyWithListParams", params);
    }
}
