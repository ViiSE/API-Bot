package ru.fd.api.bot.producer.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.RequestBody;

@Service("requestProducerDefault")
public class RequestProducerDefaultImpl implements RequestProducer {

    private final ApplicationContext ctx;

    public RequestProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Request getGetRequestInstance(String url, Auth<String> auth, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("getRequest", url, auth, responseProducer);
    }

    @Override
    public Request getPostRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("postRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getPutRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("putRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getDeleteRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("deleteRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getEmptyRequestInstance() {
        return ctx.getBean("emptyRequest", Request.class);
    }

    @Override
    public Request getRequestWithBenchInstance(Request request, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("requestWithBench", request, responseProducer);
    }
}
