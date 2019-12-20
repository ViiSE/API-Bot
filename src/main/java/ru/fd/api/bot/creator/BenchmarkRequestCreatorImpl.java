package ru.fd.api.bot.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.producer.entity.RequestProducer;

import java.util.Map;

@Service("benchmarkRequestCreator")
@Scope("prototype")
public class BenchmarkRequestCreatorImpl implements RequestCreator<Map<String, Object>> {

    private final RequestProducer requestProducer;
    private final RequestCreator<Map<String, Object>> requestCreator;

    public BenchmarkRequestCreatorImpl(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator) {
        this.requestProducer = requestProducer;
        this.requestCreator = requestCreator;
    }

    @Override
    public Request<Map<String, Object>> create() {
        return requestProducer.getBenchmarkRequestInstance(requestCreator.create());
    }
}
