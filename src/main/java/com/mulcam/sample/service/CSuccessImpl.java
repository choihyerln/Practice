package com.mulcam.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.sample.dao.CSuccessDao;
import com.mulcam.sample.entity.CSuccess;
import com.mulcam.sample.entity.ChallengeSum;

@Service
public class CSuccessImpl implements CSuccessService {
	
	@Autowired private CSuccessDao csd;
	private String startDate;
	
	@Override
	public void insert(CSuccess cs) {
		csd.insert(cs);
	}

	@Override
	public List<CSuccess> getList() {
		List<CSuccess> list = csd.getList();
		return list;
	}

	@Override
	public ChallengeSum getSum(String uid, int ver) {
		int sum = 0;
		ChallengeSum cs = new ChallengeSum();
		
		switch (ver) {
		case 0:	// today
			sum = csd.getTodaySum(uid);
			cs.setting(ver, sum);
			return cs;
			
			
		case 1:	// week
			// 오늘 기준 -7일 날짜를 보내주어야함 2023-mm-dd
			sum = csd.getWeekSum(uid, startDate);
			cs.setting(ver, sum);
			return cs;
			
			
		case 2:	// month
			// 오늘 기준 한달 전 날짜를 보내주어야 함
			sum = csd.getMonthSum(uid, startDate);
			cs.setting(ver, sum);
			return cs;
			

		default:
			return null;
			
		}
		
	}
}