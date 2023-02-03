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
	
	@Select("SELECT SUM(camount) sumToday"
			+ "FROM cSuccess s"
			+ "JOIN challenge c"
			+ "ON c.cid = s.cid"
			+ "WHERE CAST(s.sucDate AS DATE) = CURDATE()"
			+ "GROUP BY s.uid"
			+ "HAVING uid = 'admin'")
	public CSuccess getSum();
	
}
