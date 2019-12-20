package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.entity.RequestResultMapDefaultImpl;

import java.util.Map;

@Service("requestResultProducerDefault")
public class RequestResultProducerDefaultImpl implements RequestResultProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public RequestResult<Map<String, Object>> getRequestResultMapDefaultInstance(Map<String, Object> dataMap) {
        return (RequestResultMapDefaultImpl) ctx.getBean("requestResultMapDefault", dataMap);
    }
}
