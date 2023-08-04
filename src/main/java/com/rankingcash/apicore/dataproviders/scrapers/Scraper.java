package com.rankingcash.apicore.dataproviders.scrapers;

import com.rankingcash.apicore.exceptions.ScraperConnectionException;

public interface Scraper {

    void init(String url) throws ScraperConnectionException;

}
