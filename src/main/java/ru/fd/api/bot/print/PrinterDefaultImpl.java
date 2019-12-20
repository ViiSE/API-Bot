package ru.fd.api.bot.print;

import okhttp3.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.RequestResults;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Date;
import java.util.Map;

@Component("printerDefault")
@Scope("prototype")
public class PrinterDefaultImpl implements Printer<String> {

    private final RequestResult<Map<String, Object>> requestResult;
    private final DateFormatter dateFormatter;

    public PrinterDefaultImpl(RequestResult<Map<String, Object>> requestResult, DateFormatter dateFormatter) {
        this.requestResult = requestResult;
        this.dateFormatter = dateFormatter;
    }

    @Override
    public String print() {
        Response response = (Response) requestResult.findObjectByKey(RequestResults.RESPONSE);
        Date date = (Date) requestResult.findObjectByKey(RequestResults.TIME);

        return String.format("%s\n\t%s - %s\n",
                response.request().method(),
                response.request().url(),
                dateFormatter.format(date));
    }
}
