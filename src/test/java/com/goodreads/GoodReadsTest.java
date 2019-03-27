package com.goodreads;

import com.goodreads.allure.AllureEnvironmentController;
import com.goodreads.api.API;
import com.goodreads.dataproviders.GoodReadsDataProviderFactory;
import com.goodreads.utils.listeners.GoodReadsTestListener;
import com.goodreads.verification.ResponseVerification;
import com.google.inject.Inject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.*;

@Guice(modules = {APIModule.class})
@Listeners(GoodReadsTestListener.class)
@Feature("Goodreads endpoints")
@Story("Goodreads endpoints should work correctly")
public class GoodReadsTest {

    @Inject
    private API goodReadsAPI;

    @Test(description = "Verify author search (input: %s; mapping: %s output: %s)",
            dataProvider = "createAuthorSearchData", dataProviderClass = GoodReadsDataProviderFactory.class)
    public void verifyGoodReadsAuthorSearch(String inputData, String xmlMapping, String expectedData) {
        Response response = goodReadsAPI.getAuthorById(inputData);
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData(xmlMapping, Matchers.equalTo(expectedData));
    }

    @Test(description = "Verify author series search")
    public void verifyGoodReadsAuthorSeriesSearch() {
        Response response = goodReadsAPI.getAuthorSeries("12");
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.series_works.series_work.id", Matchers.hasItem("243301"));
    }

    @Test(description = "Verify book search")
    public void verifyGoodReadsBookSearch() {
        Response response = goodReadsAPI.findBook("Thinking in java");
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.search.results.work.best_book.author.name",
                        Matchers.hasItem("Bruce Eckel"));
    }

    @Test(description = "Verify book reviews search")
    public void verifyGoodReadsBookReviewsSearch() {
        Response response = goodReadsAPI.getBookReviews("1");
        new ResponseVerification(response)
                .verifyStatusCode(HttpStatus.SC_OK)
                .verifyContentType(ContentType.XML)
                .verifyResponseData("GoodreadsResponse.book.id", Matchers.equalTo("1"));
    }

    @AfterClass
    public void createPropertyFile() {
        new AllureEnvironmentController()
                .createPropertyFile();
    }

}
