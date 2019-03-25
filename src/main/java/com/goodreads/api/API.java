package com.goodreads.api;

import com.jayway.restassured.response.Response;

public interface API {

    Response getAuthorById(String authorId);

    Response getAuthorSeries(String authorId);

    Response findBook(String searchText);

    Response getBookReviews(String bookId);

}
