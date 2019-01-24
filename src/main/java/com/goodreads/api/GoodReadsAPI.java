package com.goodreads.api;

import com.goodreads.api.controllers.RequestController;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import io.qameta.allure.Allure;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;

public class GoodReadsAPI {
    private static final String BASE_URL = "https://www.goodreads.com";
    private static final String KEY = "4N4AX9WSYK4Bd2LGuKgPA";
    private static final ContentType CONTENT_TYPE = ContentType.XML;
    private static final Logger logger = LogManager.getLogger(GoodReadsAPI.class);
    private static RequestSpecification requestSpecification;

    static {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("key", KEY)
                .setContentType(CONTENT_TYPE)
                .build();
    }

    public Response getAuthorById(int authorId) {
        return new RequestController(requestSpecification).get("/author/show.xml",
                Collections.singletonMap("id", authorId));
    }

    public Response getAuthorSeries(int authorId) {
        return new RequestController(requestSpecification).get(String.format("/series/list/%d.xml", authorId));
    }

    public Response findBook(String searchText) {
        return new RequestController(requestSpecification).get("/search/index.xml",
                Collections.singletonMap("q", searchText));
    }

    public Response getBookReviews(int bookId) {
        return new RequestController(requestSpecification).get("/book/show.xml",
                Collections.singletonMap("id", bookId));
    }
}
