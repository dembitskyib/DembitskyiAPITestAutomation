package com.goodreads.verification;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.qameta.allure.Step;
import org.hamcrest.Matcher;

public class ResponseVerification {
    private Response response;

    public ResponseVerification(Response response) {
        this.response = response;
    }

    @Step("Verify response content type")
    public ResponseVerification verifyContentType(ContentType contentType) {
        response.then().assertThat().contentType(contentType);
        return this;
    }

    @Step("Verify response status code")
    public ResponseVerification verifyStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        return this;
    }

    @Step("Verify response data correctness")
    public ResponseVerification verifyResponseData(String path, Matcher expectedMatch) {
        response.then().assertThat().body(path, expectedMatch);
        return this;
    }
}
