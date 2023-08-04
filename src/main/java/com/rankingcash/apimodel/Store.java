package com.rankingcash.apimodel;

import com.google.common.net.InternetDomainName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public enum Store {

    MERCADO_LIVRE("mercadolivre.com.br"),
    AMAZON_BR("amazon.com.br"),
    NETSHOES("netshoes.com.br");

    private final String domain;

    public static Optional<Store> fromDomain(InternetDomainName domain) {
        return Arrays.stream(Store.values())
                .filter(s -> s.domain.equals(domain.toString()))
                .findFirst();
    }

}
