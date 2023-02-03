package com.mulcam.sample.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CSuccessDTO {
	
	private Integer sid;
	private LocalDateTime sucDate;
	private Integer cid;
	private String uid;
	private Integer sumToday;
	private Integer sumWeek;
	private Integer sumMonth;
	
}
