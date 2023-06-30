package com.portiaxe.exchange.dto;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRateDto {
    private String base;
    private Map<String, BigDecimal> result;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getResult() {
        return result;
    }

    public void setResult(Map<String, BigDecimal> result) {
        this.result = result;
    }
}
