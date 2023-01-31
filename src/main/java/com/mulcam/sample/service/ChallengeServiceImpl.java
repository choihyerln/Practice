package com.mulcam.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.sample.dao.ChallengeDao;
import com.mulcam.sample.entity.Challenge;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	@Autowired private ChallengeDao challengeDao;
	
	@Override
	public List<Challenge> getChallengeList() {
		List<Challenge> list = challengeDao.getChallengeList();
		return list;
	}
	@Override
	public Challenge getChallenge(int cid) {
		Challenge list = challengeDao.getChallenge(cid);
		return list;
	}

}
