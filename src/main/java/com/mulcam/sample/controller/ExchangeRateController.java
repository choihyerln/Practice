//package com.mulcam.sample.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mulcam.sample.entity.ExchangeRate;
//import com.mulcam.sample.util.ExchangeRateUtil;
//
//@RestController
//public class ExchangeRateController {
//	
//	@Autowired private ExchangeRateUtil exchangeRateUtil;
//	
//    @GetMapping("/exchange-rate")
//    public List<ExchangeRate> getExchangeRates(Model model) {
//    	
//	    System.out.println();
//    	return null;
//    	
//    	
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//        		"https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=o6PgcpRYS5ZiJ38ZEoVcBXf2IdB4pl0d", HttpMethod.GET, entity, String.class);
//        
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode root = objectMapper.readTree(response.getBody());
//        JsonNode itemList = root.path("data").path("list");
//
//        List<ExchangeRate> exchangeRates = new ArrayList<>();
//        for (JsonNode item : itemList) {
//            ExchangeRate er = new ExchangeRate();
//            er.setCur_unit(item.path("cur_unit").asText());
//            er.setCur_nm(item.path("cur_nm").asText());
//            er.setDeal_bas_r(item.path("deal_bas_r").asDouble());
//            exchangeRates.add(er);
//        }
//        return exchangeRates;
//    }
//
//}