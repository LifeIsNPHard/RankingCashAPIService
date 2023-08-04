package com.rankingcash.apicore.dataproviders.scrapers;

import com.rankingcash.apicore.exceptions.ScraperConnectionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractScraper implements Scraper {

    protected WebDriver driver;

    @Override
    public void init(String url) throws ScraperConnectionException {
        driver = new ChromeDriver();

        try {
            driver.get(url);
        } catch (Exception e) {
            throw new ScraperConnectionException(String.format("Couldn't connect to %s", url), e);
        }
    }

}
