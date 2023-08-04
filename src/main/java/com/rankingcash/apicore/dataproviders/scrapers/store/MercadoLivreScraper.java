package com.rankingcash.apicore.dataproviders.scrapers.store;

import com.rankingcash.apicore.exceptions.PriceNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MercadoLivreScraper extends AbstractStoreScraper {

    @Override
    public double getPrice() throws PriceNotFoundException {
        try {
            WebElement meta = driver.findElement(By.cssSelector("meta[itemprop = price]"));
            String value = meta.getAttribute("content");

            return Double.parseDouble(value);
        } catch (Exception e) {
            throw priceNotFoundException(e).get();
        }
    }

}
