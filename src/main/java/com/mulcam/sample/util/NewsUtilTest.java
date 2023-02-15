package com.mulcam.sample.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewsUtilTest {

//	public static String getNews(String query) throws Exception {
//
//		String clientId = "04m9x5h4CdVSrV89BrAz"; // 애플리케이션 클라이언트 아이디
//		String clientSecret = "rzPsDtaOVO"; // 애플리케이션 클라이언트 시크릿
//
//		StringBuilder urlBuilder = new StringBuilder("https://openapi.naver.com/v1/search/news.json");
//		urlBuilder.append("?" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode(query, "UTF-8"));
//		urlBuilder.append("&display=1");
//
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//		con.setRequestMethod("GET");
//		con.setRequestProperty("X-Naver-Client-Id", clientId);
//		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//
//        // Read API response
//        int responseCode = con.getResponseCode();
//        BufferedReader br;
//        if (responseCode == 200) {  // Success
//            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        } else {  // Error
//            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//        }
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = br.readLine()) != null) {
//            response.append(inputLine);
//        }
//        br.close();
//        
//     // Parse API response
//        JSONObject json = new JSONObject(response.toString());
//        JSONArray items = json.getJSONArray("items");
//
//        JSONObject item = (JSONObject)items.get(0);
//        
//        String title = (String)item.get("title");
//		String link = (String)item.get("link");
//		String description = (String)item.get("description");
//		String pubDate = (String)item.get("pubDate");
//		
//        System.out.println("PubDate: " + pubDate);
//        System.out.println("Title: " + title);
//        System.out.println("Description: " + description);
//        System.out.println("Link: " + link);
//        System.out.println();
//        
//        return response.toString();
//        
//	}
}
