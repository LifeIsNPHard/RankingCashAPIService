package com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider;

import com.rankingcash.apicore.exceptions.CashbackNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MeliuzScraper extends AbstractCashbackProviderScraper {
    @Override
    public double getCashback() throws CashbackNotFoundException {
        try {
            WebElement div = driver.findElement(By.className("partner-pg__hero-section__summary-logged"));
            WebElement span = div.findElement(By.cssSelector("span"));
            String value = span.getAttribute("textContent");
            String valueWithoutPercentageSymbol = value.substring(0, value.length() - 1);
            return Double.parseDouble(valueWithoutPercentageSymbol);
        } catch (Exception e) {
            throw cashbackNotFoundException(e).get();
        }
    }

}
