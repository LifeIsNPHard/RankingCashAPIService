package com.rankingcash.apimodel.results;

import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Product;
import com.rankingcash.apimodel.Store;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class URLQueryResult {

    private Store store;
    private Product product;
    private List<CashbackProvider> cashbackProviders;

}
