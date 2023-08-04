package com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider;

import com.rankingcash.apicore.exceptions.CashbackNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
public class InterShopScraper extends AbstractCashbackProviderScraper {
    @Override
    public double getCashback() throws CashbackNotFoundException {
        try {
            WebElement h1 = driver.findElement(By.tagName("h1"));
            String text = h1.getText();

            String[] texts = text.split("%");
            text = texts[0];

            texts = text.split(" ");
            text = texts[texts.length - 1];

            return Double.parseDouble(text);
        } catch (Exception e) {
            throw cashbackNotFoundException(e).get();
        }
    }

}
