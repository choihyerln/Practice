package com.mulcam.sample.util;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mulcam.sample.entity.ExchangeRate;

public class ExchangeRateUtilTest {
	public static void main(String[] args) {

		try {
			// 매개변수 포함하여 api 주소 만들기
			String authKey = "LycQ12X8hP28rHn6cSBHI877KqHfrJTJ";
			String searchDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			String dataType = "AP01";

			StringBuilder urlBuilder = new StringBuilder(
					"https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=");
			urlBuilder.append(authKey + "&searchdate=" + searchDate + "&data=" + dataType);

			// 객체 생성 및 url 연결
			URL url = new URL(urlBuilder.toString());
			URLConnection urlConnection = url.openConnection();

			// 데이터 받아오기
			InputStreamReader ir = new InputStreamReader(urlConnection.getInputStream());
			BufferedReader br = new BufferedReader(ir);

			String line;
			line = br.readLine();

			// 받아온 JSON 데이터 파싱하기
			// 파서 객체 만들기
			JSONParser parser = new JSONParser();

			// JSON 데이터를 파싱하여 배열로 추출
			JSONArray items = (JSONArray) parser.parse(line);

			List<ExchangeRate> list = new ArrayList<>();
			
			for (int i = 0; i < items.size(); i++) {
				JSONObject item = (JSONObject) items.get(i);

				String cur_unit = (String) item.get("cur_unit");		// 통화코드
				String cur_nm = (String) item.get("cur_nm");			// 국가명
				double deal_bas_r = (double) item.get("deal_bas_r");	// 매매기준율
				
				if (cur_unit.equals("USD") || cur_unit.equals("JPY(100)") || cur_unit.equals("EUR")) {
					ExchangeRate exchangeRate = new ExchangeRate(cur_unit, cur_nm, deal_bas_r);
					list.add(exchangeRate);
				}
			}
			
			System.out.println(list);

			br.close();
			ir.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}