package com.mulcam.sample.entity;

import java.text.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ChallengeSum {
	private int ver;
	private String top;
	private String emoji;
	private String etxt;
	private String bottom;
	private String right;
	private int sum;

	public void setting(int ver, int sum) {
		this.ver = ver;
		this.sum = sum;
		NumberFormat numberFormat = NumberFormat.getInstance();
		String sum_ = numberFormat.format(sum);
		double etxt_ = 0;
		this.bottom = "약 " + sum_ + "원을 아꼈어요!";
		
		switch (ver) {
		case 0: // 오늘
			etxt_ = Math.round((sum / 18000.0)*100)/100.0;
			this.ver = ver;
			this.top = "오늘";
			this.emoji = "";
			this.right = "주간";
			this.etxt = "치킨 " + String.format("%.2f", etxt_) + "마리";
			break;
		case 1: // 주간
			etxt_ = Math.round((sum / 2500.0)*100)/100.0;
			this.ver = ver;
			this.top = "한주간";
			this.emoji = "";
			this.right = "월간";
			this.etxt = "맥주 " + String.format("%.2f", etxt_) + "캔";
			break;
		case 2: // 월간
			etxt_ = Math.round((sum / 1000000.0)*100)/100.0;
			this.ver = ver;
			this.top = "한달간";
			this.emoji = "";
			this.etxt = String.format("%.2f", etxt_) + "아이패드";
			this.right = "일간";
			break;
		default:
			break;
		}
	}

}