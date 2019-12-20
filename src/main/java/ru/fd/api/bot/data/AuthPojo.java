package ru.fd.api.bot.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthPojo {

    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final String token;

    @JsonCreator
    public AuthPojo(
            @JsonProperty("type") String type,
            @JsonProperty("token") String token) {
        this.type = type;
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }
}
