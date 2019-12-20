package ru.fd.api.bot.entity;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Methods;
import ru.fd.api.bot.constant.RequestResults;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.entity.RequestResultProducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component("getRequestDefault")
@Scope("prototype")
public class GetRequestDefaultImpl implements Request<Map<String, Object>> {

    private final String method;
    private final String url;
    private final Auth<String> auth;
    private final RequestResultProducer requestResultProducer;

    public GetRequestDefaultImpl(String method, String url, Auth<String> auth, RequestResultProducer requestResultProducer) {
        this.method = method;
        this.url = url;
        this.auth = auth;
        this.requestResultProducer = requestResultProducer;
    }

    @Override
    public RequestResult<Map<String, Object>> execute() throws RequestException {
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .readTimeout(60, TimeUnit.MINUTES)
                    .writeTimeout(60, TimeUnit.MINUTES)
                    .build();
            okhttp3.Request request;

            if(method.equals(Methods.GET))
                request = new okhttp3.Request.Builder()
                        .url(url)
                        .addHeader("Authorization", auth.body())
                        .build();
            else
                throw new RequestException("Method: " + method + " is not GET method.");

            Response response = client.newCall(request).execute();

            Map<String, Object> mapData = new HashMap<>();
            mapData.put(RequestResults.RESPONSE, response);

            return requestResultProducer.getRequestResultMapDefaultInstance(mapData);
        } catch (IOException ex) {
            throw new RequestException(ex);
        }
    }
}
