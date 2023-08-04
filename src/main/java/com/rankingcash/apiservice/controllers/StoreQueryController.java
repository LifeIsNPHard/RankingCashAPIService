package com.rankingcash.apiservice.controllers;

import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Store;
import com.rankingcash.apimodel.requests.StoreQueryRequest;
import com.rankingcash.apimodel.results.StoreQueryResult;
import com.rankingcash.apicore.exceptions.StoreNotMappedException;
import com.rankingcash.apicore.services.CashbackProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class StoreQueryController {

    @Autowired
    private CashbackProviderService cashbackProviderService;

    @GetMapping(
            value = "/consultar-loja",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StoreQueryResult queryStore(@RequestBody StoreQueryRequest request) throws StoreNotMappedException {
        Store store = request.getStore();
        Map<CashbackProvider, String> cashbackProvidersMap = cashbackProviderService.getCashbackProviders(store);

        return StoreQueryResult.builder()
                .cashbackProviders(cashbackProvidersMap.keySet().stream().toList())
                .build();
    }

}
