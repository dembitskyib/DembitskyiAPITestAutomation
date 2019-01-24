package com.goodreads.dataproviders;

import org.testng.annotations.DataProvider;

public class GoodReadsDataProviderFactory {
    @DataProvider
    public static Object[][] createAuthorSearchData() {
        return new Object[][]{
                {"GoodreadsResponse.author.id", "11"},
                {"GoodreadsResponse.author.id", "12"},
        };
    }
}
