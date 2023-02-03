package com.mulcam.sample.service;

import java.util.List;

import com.mulcam.sample.dto.MypageSumDTO;
import com.mulcam.sample.entity.CSuccess;

public interface CSuccessService {
	
	void insert (CSuccess cs);
	
	List<CSuccess> getList();
	
	MypageSumDTO getSum(String uid);
}
