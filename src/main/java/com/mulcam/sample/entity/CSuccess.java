package com.mulcam.sample.entity;

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
public class CSuccess {

	private Integer sid;
	private LocalDateTime successDate;
	private Integer cid;
	private String uid;
	
}