package com.mulcam.sample.service;

import java.util.List;

import com.mulcam.sample.entity.CSuccess;
import com.mulcam.sample.entity.ChallengeSum;

public interface CSuccessService {
	
	void insert (CSuccess cs);
	
	List<CSuccess> getList();
	
	ChallengeSum getSum(String uid, int ver);
}
