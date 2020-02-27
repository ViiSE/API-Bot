package ru.fd.api.bot.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestPojo {

    private final String method;
    private final String url;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final AuthPojo auth;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final List<RequestBodyPojo> body;

    @JsonCreator
    public RequestPojo(
            @JsonProperty("method") String method,
            @JsonProperty("url") String url,
            @JsonProperty("auth") AuthPojo auth,
            @JsonProperty("body") List<RequestBodyPojo> body) {
        this.method = method;
        this.url = url;
        this.auth = auth;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public AuthPojo getAuth() {
        return auth;
    }

    public List<RequestBodyPojo> getBody() {
        return body;
    }
}
