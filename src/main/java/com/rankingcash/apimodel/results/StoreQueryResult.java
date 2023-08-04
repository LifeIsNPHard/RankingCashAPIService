package com.rankingcash.apimodel.results;

import com.rankingcash.apimodel.CashbackProvider;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StoreQueryResult {

    private List<CashbackProvider> cashbackProviders;

}
