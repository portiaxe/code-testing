package com.portiaxe.exchange.service;

import com.portiaxe.exchange.dao.entity.ExchangeRate;
import com.portiaxe.exchange.dao.entity.ExchangeRateId;
import com.portiaxe.exchange.dao.repo.ExchangeRateRepository;
import com.portiaxe.exchange.dto.ExchangeRateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateDto fetchSingle(String fromCurrency, String toCurrency) {
        ExchangeRateId exchangeRateId = new ExchangeRateId();
        exchangeRateId.setFromCurrency(fromCurrency);
        exchangeRateId.setToCurrency(toCurrency);

        ExchangeRate exchangeRate = exchangeRateRepository.findById(exchangeRateId).orElse(null);

        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setBase(fromCurrency);
        Map<String, BigDecimal> result = new HashMap<>();
        exchangeRateDto.setResult(result);

        if(exchangeRate != null) {
            result.put(toCurrency, exchangeRate.getRate());
        }

        return exchangeRateDto;
    }

    public ExchangeRateDto fetchMultiple(String fromCurrency, List<String> toCurrency) {

        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setBase(fromCurrency);
        Map<String, BigDecimal> result = new HashMap<>();
        exchangeRateDto.setResult(result);

        List<ExchangeRate> exchangeRates = exchangeRateRepository.findByIdFromCurrencyAndIdToCurrencyIn(fromCurrency, toCurrency);

        for(ExchangeRate exchangeRate: exchangeRates){
            result.put(exchangeRate.getId().getToCurrency(), exchangeRate.getRate());
        }
        return exchangeRateDto;
    }
}
