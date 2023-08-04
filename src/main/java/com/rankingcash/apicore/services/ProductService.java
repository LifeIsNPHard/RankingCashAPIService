package com.rankingcash.apicore.services;

import com.rankingcash.apimodel.Store;
import com.rankingcash.apicore.exceptions.PriceNotFoundException;
import com.rankingcash.apicore.exceptions.StoreNotCoveredException;
import com.rankingcash.apicore.exceptions.StoreNotMappedException;
import com.rankingcash.apimodel.Product;
import com.rankingcash.apicore.dataproviders.scrapers.store.AbstractStoreScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private Map<Store, AbstractStoreScraper> storeProductScraperMap;

    public Product getProduct(String url)
            throws StoreNotCoveredException, StoreNotMappedException, PriceNotFoundException {
        Store store = storeService.getStore(url);
        AbstractStoreScraper storeScraper = getStoreScraper(store);

        try {
            storeScraper.init(url);

            return Product.builder()
                    .price(storeScraper.getPrice())
                    .build();
        } catch (Exception e) {
            throw new PriceNotFoundException(String.format("Price not found for url %s", url), e);
        }
    }

    private AbstractStoreScraper getStoreScraper(Store store) throws StoreNotMappedException {
        if (storeProductScraperMap.containsKey(store)) {
            return storeProductScraperMap.get(store);
        } else {
            throw new StoreNotMappedException(String.format("Store %s not mapped to a Scraper", store.name()));
        }
    }

}
