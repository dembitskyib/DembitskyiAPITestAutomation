package com.goodreads.allure;

import com.jayway.restassured.response.Response;
import io.qameta.allure.Attachment;

public class AttachmentController {

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    @Attachment(value = "{name}", type = "text/xml")
    public static String attachXmlResponse(String name, Response response) {
        return response.getBody().prettyPrint();
    }

}
