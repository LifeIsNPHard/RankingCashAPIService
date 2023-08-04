package com.rankingcash.apicore.dataproviders.scrapers.store;

import com.rankingcash.apicore.exceptions.PriceNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NetshoesScraper extends AbstractStoreScraper {

    @Override
    public double getPrice() throws PriceNotFoundException {
        try {
            WebElement input = driver.findElement(By.id("hiddenPriceSaleInCents"));
            String value = input.getAttribute("value");

            return Double.parseDouble(value) / 100;
        } catch (Exception e) {
            throw priceNotFoundException(e).get();
        }
    }

}
