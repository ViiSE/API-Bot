package test.print;

import ru.fd.api.bot.constant.RequestResults;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.print.Printer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Date;
import java.util.Map;

public class PrinterTestImpl implements Printer<String> {

    private final RequestResult<Map<String, Object>> requestResult;
    private final DateFormatter dateFormatter;

    public PrinterTestImpl(RequestResult<Map<String, Object>> requestResult, DateFormatter dateFormatter) {
        this.requestResult = requestResult;
        this.dateFormatter = dateFormatter;
    }

    @Override
    public String print() {
        TestResponse response = (TestResponse) requestResult.findObjectByKey(RequestResults.RESPONSE);
        Date date = (Date) requestResult.findObjectByKey(RequestResults.TIME);

        return String.format("%s\n\t%s - %s\n",
                response.method(),
                response.url(),
                dateFormatter.format(date));
    }
}
