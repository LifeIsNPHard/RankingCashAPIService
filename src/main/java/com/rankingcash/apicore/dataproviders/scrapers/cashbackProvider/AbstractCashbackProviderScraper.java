package com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider;

import com.rankingcash.apicore.dataproviders.CashbackProviderDataProvider;
import com.rankingcash.apicore.exceptions.CashbackNotFoundException;
import com.rankingcash.apicore.dataproviders.scrapers.AbstractScraper;

import java.util.function.Supplier;

public abstract class AbstractCashbackProviderScraper extends AbstractScraper implements CashbackProviderDataProvider {

    @Override
    public abstract double getCashback() throws CashbackNotFoundException;

    protected Supplier<CashbackNotFoundException> cashbackNotFoundException(Exception e) {
        return () -> new CashbackNotFoundException(
                String.format("Cashback not found for url %s", driver.getCurrentUrl()), e);
    }

}
