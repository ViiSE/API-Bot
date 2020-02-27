package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.entity.ResponseProducer;

@Component("requestWithBench")
@Scope("prototype")
public class RequestWithBenchImpl implements Request {

    private final Request request;
    private final ResponseProducer responseProducer;

    public RequestWithBenchImpl(Request request, ResponseProducer responseProducer) {
        this.request = request;
        this.responseProducer = responseProducer;
    }

    @Override
    public Response execute() throws RequestException {
        long timeStart = System.currentTimeMillis();
        Response response = request.execute();
        long timeEnd = System.currentTimeMillis();

        return responseProducer.getResponseWithBenchTimeInstance(response, (timeEnd - timeStart));
    }
}
