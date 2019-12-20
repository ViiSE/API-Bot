package ru.fd.api.bot.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SettingsPojo {

    private final String filename;
    private final String hostname;
    private final int repeat;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final AuthPojo auth;
    private final List<RequestPojo> requests;

    @JsonCreator
    public SettingsPojo(
            @JsonProperty("filename") String filename,
            @JsonProperty("hostname") String hostname,
            @JsonProperty("repeat") int repeat,
            @JsonProperty("auth") AuthPojo auth,
            @JsonProperty("requests") List<RequestPojo> requests) {
        this.filename = filename;
        this.hostname = hostname;
        this.repeat = repeat;
        this.auth = auth;
        this.requests = requests;
    }

    public String getFilename() {
        return filename;
    }

    public String getHostname() {
        return hostname;
    }

    public int getRepeat() {
        return repeat;
    }

    public AuthPojo getAuth() {
        return auth;
    }

    public List<RequestPojo> getRequests() {
        return requests;
    }
}
