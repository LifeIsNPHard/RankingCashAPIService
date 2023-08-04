package com.rankingcash.apiservice.controllers;

import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.requests.CashbackQueryRequest;
import com.rankingcash.apimodel.results.CashbackQueryResult;
import com.rankingcash.apimodel.Store;
import com.rankingcash.apicore.exceptions.CashbackNotFoundException;
import com.rankingcash.apicore.exceptions.CashbackProviderNotMappedException;
import com.rankingcash.apicore.exceptions.StoreNotMappedException;
import com.rankingcash.apicore.services.CashbackProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CashbackQueryController {

    @Autowired
    private CashbackProviderService cashbackProviderService;

    @GetMapping(
            value = "/consultar-cashback",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CashbackQueryResult queryCashback(@RequestBody CashbackQueryRequest request)
            throws StoreNotMappedException, CashbackProviderNotMappedException, CashbackNotFoundException {
        Store store = request.getStore();
        CashbackProvider cashbackProvider = request.getCashbackProvider();

        return CashbackQueryResult.builder()
                .cashback(cashbackProviderService.getCashback(store, cashbackProvider))
                .build();
    }

}
