package com.goodreads.api.controllers;

import com.goodreads.allure.AllureAttachmentController;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Step;

import java.util.Collections;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestController {

    private RequestSpecification requestSpecification;

    public RequestController(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response get(String url) {
        return get(url, Collections.emptyMap());
    }

    @Step("Send request")
    public Response get(String url, Map<String, ?> queryParams) {
        Response response = given()
                .specification(requestSpecification)
                .queryParameters(queryParams)
                .when()
                .get(url)
                .then()
                .extract().response();
        AllureAttachmentController.attachXmlResponse("Response body", response);
        return response;
    }

}
