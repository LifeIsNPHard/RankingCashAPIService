package com.rankingcash.apicore.services;

import com.rankingcash.apicore.exceptions.CashbackNotFoundException;
import com.rankingcash.apicore.exceptions.StoreNotMappedException;
import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider.AbstractCashbackProviderScraper;
import com.rankingcash.apicore.exceptions.CashbackProviderNotMappedException;
import com.rankingcash.apimodel.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CashbackProviderService {

    @Autowired
    private Map<Store, Map<CashbackProvider, String>> storeCashbackProvidersMap;

    @Autowired
    private Map<CashbackProvider, AbstractCashbackProviderScraper> cashbackProviderScraperMap;

    public Map<CashbackProvider, String> getCashbackProviders(Store store) throws StoreNotMappedException {
        if (storeCashbackProvidersMap.containsKey(store)) {
            return storeCashbackProvidersMap.get(store);
        } else {
            throw new StoreNotMappedException(
                    String.format("Store '%s' not mapped to Cashback Providers", store.name()));
        }
    }

    public double getCashback(Store store, CashbackProvider cashbackProvider)
            throws StoreNotMappedException, CashbackProviderNotMappedException, CashbackNotFoundException {
        String url = getCasbackProviderURL(store, cashbackProvider);
        AbstractCashbackProviderScraper cashbackProviderScraper = getCashbackProviderScraper(cashbackProvider);

        try {
            cashbackProviderScraper.init(url);
            return cashbackProviderScraper.getCashback();
        } catch (Exception e) {
            throw new CashbackNotFoundException(String.format("Cashback not found for url %s", url), e);
        }
    }

    private String getCasbackProviderURL(Store store, CashbackProvider cashbackProvider)
            throws StoreNotMappedException {
        Map<CashbackProvider, String> cashbackProviders = getCashbackProviders(store);
        if (cashbackProviders.containsKey(cashbackProvider)) {
            return cashbackProviders.get(cashbackProvider);
        } else {
            throw new StoreNotMappedException(String.format("Store %s not mapped to Cashback Provider %s",
                    store.name(), cashbackProvider.name()));
        }
    }

    private AbstractCashbackProviderScraper getCashbackProviderScraper(CashbackProvider cashbackProvider)
            throws CashbackProviderNotMappedException {
        if (cashbackProviderScraperMap.containsKey(cashbackProvider)) {
            return cashbackProviderScraperMap.get(cashbackProvider);
        } else {
            throw new CashbackProviderNotMappedException(
                    String.format("Cashback Provider %s not mapped to Scraper", cashbackProvider.name()));
        }
    }

}
