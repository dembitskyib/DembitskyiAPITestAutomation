package com.goodreads.api;

import com.goodreads.api.controllers.RequestController;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.Collections;

public class GoodReadsAPI implements API {

    private static final String BASE_URL = "https://www.goodreads.com";
    private static final String KEY = "4N4AX9WSYK4Bd2LGuKgPA";
    private static final ContentType CONTENT_TYPE = ContentType.XML;
    private static RequestSpecification requestSpecification;

    static {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("key", KEY)
                .setContentType(CONTENT_TYPE)
                .build();
    }

    public GoodReadsAPI() {
    }

    public Response getAuthorById(String authorId) {
        return new RequestController(requestSpecification).get("/author/show.xml",
                Collections.singletonMap("id", authorId));
    }

    public Response getAuthorSeries(String authorId) {
        return new RequestController(requestSpecification).get(String.format("/series/list/%s.xml", authorId));
    }

    public Response findBook(String searchText) {
        return new RequestController(requestSpecification).get("/search/index.xml",
                Collections.singletonMap("q", searchText));
    }

    public Response getBookReviews(String bookId) {
        return new RequestController(requestSpecification).get("/book/show.xml",
                Collections.singletonMap("id", bookId));
    }

}
