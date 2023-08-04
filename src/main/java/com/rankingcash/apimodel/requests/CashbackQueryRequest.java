package com.rankingcash.apimodel.requests;

import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CashbackQueryRequest {

    private Store store;
    private CashbackProvider cashbackProvider;

}
