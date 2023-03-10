package com.mulcam.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.sample.entity.CSuccess;
import com.mulcam.sample.entity.Challenge;

@Mapper
public interface ChallengeDao {
	
	@Select("select * from challenge")
	public List<Challenge> getChallengeList();
	
	@Select("select * from challenge where cid=#{cid}")
	public Challenge getChallenge(int cid);
	
	@Insert("insert into cSuccess values(#{cid})")
	void insert(CSuccess c);
	
}
