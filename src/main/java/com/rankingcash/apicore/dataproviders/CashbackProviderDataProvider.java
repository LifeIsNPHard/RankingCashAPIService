package com.rankingcash.apicore.dataproviders;

import com.rankingcash.apicore.exceptions.CashbackNotFoundException;

public interface CashbackProviderDataProvider {

    double getCashback() throws CashbackNotFoundException;

}
