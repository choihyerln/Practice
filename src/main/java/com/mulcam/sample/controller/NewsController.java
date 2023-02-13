package com.mulcam.sample.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.sample.util.Util;

@Controller
@RequestMapping("/news")
public class NewsController {
    	
		@Autowired private Util util;
		@Value("${clientId}") private String clientId;
		@Value("${clientSecret}") private String clientSecret;
		
    	@GetMapping("/news")
        public String naverNews(Model model) {
        try {

            String apiUrl = "https://openapi.naver.com/v1/search/news.json";

            // API parameters
            String query = URLEncoder.encode("금리", "UTF-8");
            String display = "1";  
            String start = "1";  

            // Create URL for API request
            URL url = new URL(apiUrl + "?query=" + query + "&display=" + display + "&start=" + start);

            // Open connection to URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set request properties
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            // Read API response
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {  // Success
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // Error
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // Parse API response
            JSONObject json = new JSONObject(response.toString());
            JSONArray items = json.getJSONArray("items");

            JSONObject item = (JSONObject)items.get(0);
            
            String title = (String)item.get("title");
			String link = (String)item.get("link");
			String description = (String)item.get("description");
			String pubDate = (String)item.get("pubDate");

            
            // Add news articles to model
            model.addAttribute("pubDate", pubDate.substring(0, 16));
            model.addAttribute("title", title);
            model.addAttribute("description", description);
            model.addAttribute("link", link);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return "news/news";
    }
}
