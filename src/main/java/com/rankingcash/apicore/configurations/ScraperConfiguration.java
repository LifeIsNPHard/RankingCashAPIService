package com.rankingcash.apicore.configurations;

import com.google.common.collect.ImmutableMap;
import com.rankingcash.apicore.dataproviders.scrapers.store.NetshoesScraper;
import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Store;
import com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider.AbstractCashbackProviderScraper;
import com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider.InterShopScraper;
import com.rankingcash.apicore.dataproviders.scrapers.cashbackProvider.MeliuzScraper;
import com.rankingcash.apicore.dataproviders.scrapers.store.AbstractStoreScraper;
import com.rankingcash.apicore.dataproviders.scrapers.store.AmazonBrScraper;
import com.rankingcash.apicore.dataproviders.scrapers.store.MercadoLivreScraper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ScraperConfiguration {

    @Bean
    public Map<Store, AbstractStoreScraper> storeProductScraperMap() {
        return ImmutableMap.of(
                Store.MERCADO_LIVRE, new MercadoLivreScraper(),
                Store.AMAZON_BR, new AmazonBrScraper(),
                Store.NETSHOES, new NetshoesScraper()
        );
    }

    @Bean
    public Map<CashbackProvider, AbstractCashbackProviderScraper> cashbackProviderScraperMap() {
        return ImmutableMap.of(
                CashbackProvider.MELIUZ, new MeliuzScraper(),
                CashbackProvider.INTER_SHOP, new InterShopScraper()
        );
    }

}
