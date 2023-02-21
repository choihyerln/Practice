package com.mulcam.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	// NOT NULL
	private Long uid;			// pri
	private String id;			// uni
	private String pwd;
	private String nickname;		// uni
	private String email;
	
	// NULL
	private String tel;
	private int pay;
	private String departures;
	private String arrivals;
	private String vehicles;
}