package ru.fd.api.bot.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RequestPojoTestNG {

    private AuthPojo authPojo;

    @BeforeClass
    @Parameters({"type", "token"})
    private void setUpClass(String type, String token) {
        authPojo = new AuthPojo(type, token);
    }

    @Test
    @Parameters({"method", "url"})
    public void serialize_withoutBody(String method, String url) throws JsonProcessingException {
        RequestPojo reqPojo = new RequestPojo(method, url, authPojo, null);

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(reqPojo));
    }

    @Test
    @Parameters({"postMethod", "url"})
    public void serialize_withBody(String postMethod, String url) throws JsonProcessingException {
        RequestPojo reqPojo = new RequestPojo(
                postMethod,
                url,
                authPojo,
                new ArrayList<>() {{
                    add(new RequestBodyPojo("paramName1", "value1"));
                    add(new RequestBodyPojo("paramName2", "value2"));
                    add(new RequestBodyPojo("paramName3", "value3"));
                }});

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(reqPojo));
    }

    @Test(dataProvider = "jsonDp")
    public void deserialize(String json, String cause) throws JsonProcessingException {
        System.out.println(cause);

        RequestPojo reqPojo = new ObjectMapper().readValue(json, RequestPojo.class);

        System.out.println("method: " + reqPojo.getMethod());
        System.out.println("url: " + reqPojo.getUrl());
        System.out.println("auth: " + reqPojo.getAuth());
        if(reqPojo.getBody() == null)
            System.out.println("body: " + reqPojo.getBody());
        else {
            System.out.println("body: ");
            reqPojo.getBody().forEach(reqBody -> {
                System.out.println("\tname: " + reqBody.getName());
                System.out.println("\tvalue: " + reqBody.getValue());
            });
        }

    }

    @DataProvider(name = "jsonDp")
    public Object[][] createDP() {
        return new Object[][] {
                {
                    "{ " +
                            "\"method\": \"GET\"," +
                            "\"url\": \"/rest/points/point\"," +
                            "\"auth\": {" +
                                "\"type\": \"Bearer\", \"token\": \"'Token here'\"" +
                            "}" +
                    "}",
                    "[with auth, without body]"
                },
                {
                        "{ " +
                                "\"method\": \"GET\"," +
                                "\"url\": \"/rest/points/point\"" +
                        "}",
                        "[without auth, without body]"
                },
                {
                        "{ " +
                                "\"method\": \"GET\"," +
                                "\"url\": \"/rest/points/point\"," +
                                "\"auth\": {" +
                                    "\"type\": \"Bearer\", \"token\": \"'Token here'\"" +
                                "}," +
                                "\"body\":[" +
                                    "{" +
                                        "\"name\":\"paramName1\"," +
                                        "\"value\":\"paramVal1\"" +
                                    "}," +
                                    "{" +
                                        "\"name\":\"paramName2\"," +
                                        "\"value\":\"paramVal2\"" +
                                    "}," +
                                    "{" +
                                        "\"name\":\"paramName3\"," +
                                        "\"value\":\"paramVal3\"" +
                                    "}" +
                                "]" +
                        "}",
                        "[with auth, with body]"
                },
                {
                        "{ " +
                                "\"method\": \"GET\"," +
                                "\"url\": \"/rest/points/point\"," +
                                "\"body\":[" +
                                    "{" +
                                        "\"name\":\"paramName1\"," +
                                        "\"value\":\"paramVal1\"" +
                                    "}," +
                                    "{" +
                                        "\"name\":\"paramName2\"," +
                                        "\"value\":\"paramVal2\"" +
                                    "}," +
                                    "{" +
                                        "\"name\":\"paramName3\"," +
                                        "\"value\":\"paramVal3\"" +
                                    "}" +
                                "]" +
                        "}",
                        "[without auth, with body]"
                },
        };
    }
}
