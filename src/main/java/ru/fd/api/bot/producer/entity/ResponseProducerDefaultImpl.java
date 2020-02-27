package ru.fd.api.bot.producer.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Response;

@Service("responseProducerDefault")
public class ResponseProducerDefaultImpl implements ResponseProducer {

    private final ApplicationContext ctx;

    public ResponseProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Response getGetResponseWithUrlInstance(String url) {
        return (Response) ctx.getBean("getResponseWithUrl", url);
    }

    @Override
    public Response getPostResponseWithUrlInstance(String url) {
        return (Response) ctx.getBean("postResponseWithUrl", url);
    }

    @Override
    public Response getPutResponseWithUrlInstance(String url) {
        return (Response) ctx.getBean("putResponseWithUrl", url);
    }

    @Override
    public Response getDeleteResponseWithUrlInstance(String url) {
        return (Response) ctx.getBean("deleteResponseWithUrl", url);
    }

    @Override
    public Response getResponseWithBenchTimeInstance(Response response, long evaluateTime) {
        return (Response) ctx.getBean("responseWithBenchTime", response, evaluateTime);
    }

    @Override
    public Response getEmptyResponseInstance() {
        return ctx.getBean("emptyResponse", Response.class);
    }
}
