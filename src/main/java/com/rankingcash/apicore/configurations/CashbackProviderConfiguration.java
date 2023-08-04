package com.rankingcash.apicore.configurations;

import com.google.common.collect.ImmutableMap;
import com.rankingcash.apimodel.CashbackProvider;
import com.rankingcash.apimodel.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CashbackProviderConfiguration {

    @Bean
    public Map<Store, Map<CashbackProvider, String>> storeCashbackProvidersMap() {
        return ImmutableMap.of(
                Store.MERCADO_LIVRE, ImmutableMap.of(
                        CashbackProvider.MELIUZ, "https://www.meliuz.com.br/desconto/cupom-desconto-mercado-livre"
                ),
                Store.AMAZON_BR, ImmutableMap.of(
                        CashbackProvider.MELIUZ, "https://www.meliuz.com.br/desconto/cupom-desconto-amazon",
                        CashbackProvider.INTER_SHOP, "https://intershop.bancointer.com.br/lojas/amazon"
                ),
                Store.NETSHOES, ImmutableMap.of(
                        CashbackProvider.MELIUZ, "https://www.meliuz.com.br/desconto/cupom-netshoes",
                        CashbackProvider.INTER_SHOP, "https://intershop.bancointer.com.br/lojas/netshoes"
                )
        );
    }

}
