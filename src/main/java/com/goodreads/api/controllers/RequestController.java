package com.goodreads.api.controllers;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Allure;

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

    public Response get(String url, Map<String, ?> queryParams) {
        Response response = given()
                .specification(requestSpecification)
                .queryParameters(queryParams)
                .when()
                .get(url)
                .then()
                .extract().response();
        Allure.addAttachment("Response body", "text/xml", response.getBody().asString());
        return response;
    }
}
