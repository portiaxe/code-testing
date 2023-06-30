package com.portiaxe.exchange.dao.repo;

import com.portiaxe.exchange.dao.entity.ExchangeRate;
import com.portiaxe.exchange.dao.entity.ExchangeRateId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, ExchangeRateId> {
//    ExchangeRate findByIdFromCurrencyAndIdToCurrencyOrIdToCurrencyAndFromCurrency(String fromCurrency, String toCurrency, String )
    List<ExchangeRate> findByIdFromCurrencyAndIdToCurrencyIn(String toCurrency, List<String> toCurrencies);
}
