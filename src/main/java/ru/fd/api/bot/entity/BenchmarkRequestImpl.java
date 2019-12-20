package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.RequestResults;
import ru.fd.api.bot.exception.RequestException;

import java.util.Date;
import java.util.Map;

@Component("benchmarkRequest")
@Scope("prototype")
public class BenchmarkRequestImpl implements Request<Map<String, Object>> {

    private final Request<Map<String, Object>> request;

    public BenchmarkRequestImpl(Request<Map<String, Object>> request) {
        this.request = request;
    }

    @Override
    public RequestResult<Map<String, Object>> execute() throws RequestException {
        long timeStart = System.currentTimeMillis();
        RequestResult<Map<String, Object>> reqRes = request.execute();
        long timeEnd = System.currentTimeMillis();

        reqRes.data().put(RequestResults.TIME, new Date(timeEnd - timeStart));

        return reqRes;
    }
}
