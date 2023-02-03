package com.mulcam.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.sample.dao.CSuccessDao;
import com.mulcam.sample.dto.MypageSumDTO;
import com.mulcam.sample.entity.CSuccess;

@Service
public class CSuccessImpl implements CSuccessService {
	
	@Autowired private CSuccessDao csd;
	
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
	public MypageSumDTO getSum(String uid) {
		MypageSumDTO mypageSumDTO = new MypageSumDTO();
		mypageSumDTO.setChallengeToday(csd.getTodaySum(uid));
		mypageSumDTO.setChallengeWeek(csd.getWeekSum(uid));
		mypageSumDTO.setChallengeMonth(csd.getMonthSum(uid));
		return mypageSumDTO;
			
	}
}