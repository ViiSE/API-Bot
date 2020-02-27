package ru.fd.api.bot.entity;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Date;

@Component("responseFormatPretty")
public class ResponseFormatPrettyImpl implements ResponseFormat<String> {

    private final DateFormatter dateFormatter;

    public ResponseFormatPrettyImpl(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public String format(Response response) {
        return String.format("%s\n\t%s - %s\n",
                response.method(),
                response.url(),
                dateFormatter.format(new Date(response.evaluateTime())));
    }
}
