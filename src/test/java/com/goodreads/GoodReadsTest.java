package com.goodreads;

import com.goodreads.api.GoodReadsAPI;
import com.goodreads.verification.ResponseVerification;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GoodReadsTest {
    @Test(description = "Verify author search")
    public void verifyGoodReadsAuthorSearch() {
        Response response = new GoodReadsAPI().getAuthorById(12);
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.author.id", Matchers.equalTo("12"));
    }

    @Test(description = "Verify author series search")
    public void verifyGoodReadsAuthorSeriesSearch() {
        Response response = new GoodReadsAPI().getAuthorSeries(12);
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.series_works.series_work.id", Matchers.hasItem("243301"));
    }

    @Test(description = "Verify book search")
    public void verifyGoodReadsBookSearch() {
        Response response = new GoodReadsAPI().findBook("Thinking in java");
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.search.results.work.best_book.author.name",
                        Matchers.hasItem("Bruce Eckel"));
    }

    @Test(description = "Verify book reviews search")
    public void verifyGoodReadsBookReviewsSearch() {
        Response response = new GoodReadsAPI().getBookReviews(1);
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.book.id", Matchers.equalTo("1"));
    }

}
