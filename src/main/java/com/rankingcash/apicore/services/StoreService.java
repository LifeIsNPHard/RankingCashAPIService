package com.rankingcash.apicore.services;

import com.google.common.net.InternetDomainName;
import com.rankingcash.apimodel.Store;
import com.rankingcash.apicore.exceptions.StoreNotCoveredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Optional;

@Slf4j
@Service
public class StoreService {

    public Store getStore(String url) throws StoreNotCoveredException {
        try {
            URL urlObject = new URL(url);
            String host = urlObject.getHost();
            InternetDomainName domain = InternetDomainName.from(host);

            log.info("Looking for Store with domain '{}'", domain);

            Optional<Store> store;
            while ((store = Store.fromDomain(domain)).isEmpty()) {
                domain = domain.parent();
            }
            return store.get();
        } catch (Exception e) {
            throw new StoreNotCoveredException("Store not covered", e);
        }
    }

}
