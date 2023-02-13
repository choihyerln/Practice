package com.mulcam.sample.util;

public class NewsTest {
	
	public static void main(String[] args) {
		try {
			String news1 = NewsUtil.getNews("금리");
			String news2 = NewsUtil.getNews("주택");
			String news3 = NewsUtil.getNews("주식");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}