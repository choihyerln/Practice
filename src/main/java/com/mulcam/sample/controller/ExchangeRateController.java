package com.mulcam.sample.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ExchangeRateController {

    @GetMapping("/exchange-rate")
    public ResponseEntity<String> getExchangeRate() throws IOException {
        String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=o6PgcpRYS5ZiJ38ZEoVcBXf2IdB4pl0d&data=AP01";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        
        // API 응답을 List<Map> 형태로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> exchangeRateList = (List<Map<String, Object>>) objectMapper.readValue(response.getBody(), new TypeReference() {});
        
        // 현재 날짜와 전일 날짜 구하기
        LocalDate today = LocalDate.now();
        LocalDate yDay = today.minusDays(1);
        String yesterday = new SimpleDateFormat("yyyyMMdd").format(yDay);
        System.out.println(today);
        System.out.println(yesterday);
        
        // 현재 날짜와 전일 날짜의 환율 정보 구하기
        Map<String, Object> todayExchangeRate = null;
        Map<String, Object> yesterdayExchangeRate = null;
        for (Map<String, Object> exchangeRate : exchangeRateList) {
            String dateStr = exchangeRate.get("date").toString();
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
            if (date.equals(today)) {
                todayExchangeRate = exchangeRate;
            } else if (date.equals(yesterday)) {
                yesterdayExchangeRate = exchangeRate;
            }
        }
        
        // 전일 대비 환율 변동 계산하기
        if (todayExchangeRate != null && yesterdayExchangeRate != null) {
            double todayRate = Double.parseDouble(todayExchangeRate.get("deal_bas_r").toString());
            double yesterdayRate = Double.parseDouble(yesterdayExchangeRate.get("deal_bas_r").toString());
            double diff = todayRate - yesterdayRate;
            return ResponseEntity.ok().body("전일 대비 환율 변동: " + diff);
        } else {
            return ResponseEntity.badRequest().body("환율 정보가 없습니다.");
        }
    }

}
