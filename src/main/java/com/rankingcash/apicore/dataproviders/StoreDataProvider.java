package com.rankingcash.apicore.dataproviders;

import com.rankingcash.apicore.exceptions.PriceNotFoundException;

public interface StoreDataProvider {

    double getPrice() throws PriceNotFoundException;

}
