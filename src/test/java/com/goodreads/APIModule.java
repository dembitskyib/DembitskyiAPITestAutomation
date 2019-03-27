package com.goodreads;

import com.goodreads.api.API;
import com.goodreads.api.GoodReadsAPI;
import com.google.inject.AbstractModule;

public class APIModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(API.class).to(GoodReadsAPI.class);
    }
}
