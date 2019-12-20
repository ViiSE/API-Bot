package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Requests;

import java.util.List;

@Service("requestsProducerDefault")
public class RequestsProducerDefaultImpl implements RequestsProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Requests getRequestsDefaultInstance(List<Request> requests) {
        return (Requests) ctx.getBean("requestsDefault", requests);
    }
}
