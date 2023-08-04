package com.rankingcash.apicore.dataproviders.scrapers.store;

import com.rankingcash.apicore.dataproviders.StoreDataProvider;
import com.rankingcash.apicore.dataproviders.scrapers.AbstractScraper;
import com.rankingcash.apicore.exceptions.PriceNotFoundException;

import java.util.function.Supplier;

public abstract class AbstractStoreScraper extends AbstractScraper implements StoreDataProvider {

    @Override
    public abstract double getPrice() throws PriceNotFoundException;

    protected Supplier<PriceNotFoundException> priceNotFoundException(Exception e) {
        return () -> new PriceNotFoundException(
                String.format("Price not found for url %s", driver.getCurrentUrl()), e);
    }

}
