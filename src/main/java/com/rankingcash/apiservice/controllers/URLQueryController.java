package com.rankingcash.apiservice.controllers;

import com.rankingcash.apicore.exceptions.PriceNotFoundException;
import com.rankingcash.apicore.exceptions.StoreNotCoveredException;
import com.rankingcash.apicore.exceptions.StoreNotMappedException;
import com.rankingcash.apimodel.Product;
import com.rankingcash.apimodel.requests.URLQueryRequest;
import com.rankingcash.apimodel.results.URLQueryResult;
import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Store;
import com.rankingcash.apicore.services.CashbackProviderService;
import com.rankingcash.apicore.services.ProductService;
import com.rankingcash.apicore.services.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class URLQueryController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CashbackProviderService cashbackProviderService;

    @GetMapping(
            value = "/consultar-url",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public URLQueryResult queryURL(@RequestBody URLQueryRequest request)
            throws StoreNotCoveredException, StoreNotMappedException, PriceNotFoundException {
        String url = request.getUrl();
        Store store = storeService.getStore(url);
        Product product = productService.getProduct(url);
        Map<CashbackProvider, String> cashbackProvidersMap = cashbackProviderService.getCashbackProviders(store);

        return URLQueryResult.builder()
                .store(store)
                .product(product)
                .cashbackProviders(cashbackProvidersMap.keySet().stream().toList())
                .build();
    }

}
