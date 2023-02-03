package com.mulcam.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
@Builder
public class Cal {
	int sumToday;
	int sumWeek;
	int sumMonth;
	int mateToday;
	int mateWeek;
	int mateMonth;
}