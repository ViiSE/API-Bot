package ru.fd.api.bot.entity;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.producer.entity.ResponseProducer;

@Component("emptyRequest")
public class EmptyRequestImpl implements Request {

    private final ResponseProducer responseProducer;

    public EmptyRequestImpl(ResponseProducer responseProducer) {
        this.responseProducer = responseProducer;
    }

    @Override
    public Response execute() {
        return responseProducer.getEmptyResponseInstance();
    }
}
