package com.portiaxe.exchange.controller;

import com.portiaxe.exchange.dao.entity.ExchangeRate;
import com.portiaxe.exchange.dao.repo.ExchangeRateRepository;
import com.portiaxe.exchange.dto.ExchangeRateDto;
import com.portiaxe.exchange.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/fetch-one")
    public ResponseEntity<ExchangeRateDto> exchangeRate(@RequestParam("from") String from, @RequestParam("to") String to) {
        return ResponseEntity.ok(exchangeRateService.fetchSingle(from, to));
    }

    @GetMapping("/fetch-multiple")
    public ResponseEntity<ExchangeRateDto> exchangeRateMultiple(@RequestParam("from") String from, @RequestParam("to") List<String> to) {
        return ResponseEntity.ok(exchangeRateService.fetchMultiple(from, to));
    }
}
