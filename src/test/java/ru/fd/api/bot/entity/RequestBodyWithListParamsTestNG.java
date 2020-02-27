package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.fd.api.bot.data.RequestBodyPojo;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RequestBodyWithListParamsTestNG {

    private List<RequestBodyPojo> requestBodyPojos;
    private RequestBody<RequestBodyPojo> requestBody;

    @BeforeClass
    public void setUpClass() {
        requestBodyPojos = new ArrayList<>() {{
            add(new RequestBodyPojo("name1", "value1"));
            add(new RequestBodyPojo("name2", "value2"));
            add(new RequestBodyPojo("name3", "value3"));
        }};
        requestBody = new RequestBodyWithListParamsImpl(requestBodyPojos);
    }

    @Test
    public void requestBodyParams() {
        List<RequestBodyPojo> requestBodyPojoList = requestBody.requestBodyParams();
        requestBodyPojoList.forEach(requestBodyPojo -> {
            System.out.println("--------------------------------------");
            System.out.println("\tname: " + requestBodyPojo.getName());
            System.out.println("\tvalue: " + requestBodyPojo.getValue());
        });

        assertEquals(requestBodyPojos, requestBodyPojoList);
    }
}
