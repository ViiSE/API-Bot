package ru.fd.api.bot.entity;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Auths;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.entity.ResponseProducer;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component("getRequest")
@Scope("prototype")
public class GetRequestImpl implements Request {

    private final String url;
    private final Auth<String> auth;
    private final ResponseProducer responseProducer;

    public GetRequestImpl(String url, Auth<String> auth, ResponseProducer responseProducer) {
        this.url = url;
        this.auth = auth;
        this.responseProducer = responseProducer;
    }

    @Override
    public Response execute() throws RequestException {
        ResponseBody body = null;
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .readTimeout(60, TimeUnit.MINUTES)
                    .writeTimeout(60, TimeUnit.MINUTES)
                    .build();

            okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(url);
            okhttp3.Request request;

            if (auth.body().contains(Auths.NONE))
                request = builder.build();
            else
                request = builder
                        .addHeader("Authorization", auth.body())
                        .build();

            okhttp3.Response response = client.newCall(request).execute();
            body = response.body();

            Objects.requireNonNull(response.body()).close();

            return responseProducer.getGetResponseWithUrlInstance(url);
        } catch (IOException ex) {
            throw new RequestException(ex);
        } finally {
            if(body != null)
                body.close();
        }
    }
}
