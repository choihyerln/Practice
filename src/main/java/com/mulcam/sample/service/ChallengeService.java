package com.mulcam.sample.service;

import java.util.List;

import com.mulcam.sample.entity.CSuccess;
import com.mulcam.sample.entity.Challenge;

public interface ChallengeService {
	
	List<Challenge> getChallengeList();
	
	public Challenge getChallenge(int cid);
	
	void insert (CSuccess c);
	
	CSuccess getSum();
}
