package ru.fd.api.bot.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@Component("requestsDefault")
@Scope("prototype")
public class RequestsDefaultImpl implements Requests {

    private final List<Request> requests;

    public RequestsDefaultImpl(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public void forEach(Consumer<? super Request> action) {
        requests.forEach(action);
    }

    @NotNull
    @Override
    public Iterator<Request> iterator() {
        return requests.iterator();
    }
}
