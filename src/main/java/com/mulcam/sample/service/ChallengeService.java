package com.mulcam.sample.service;

import java.util.List;

import com.mulcam.sample.entity.Challenge;

public interface ChallengeService {
	
	public List<Challenge> getChallengeList();
	
	public Challenge getChallenge(int cid);
}
