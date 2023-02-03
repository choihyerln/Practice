package com.mulcam.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.sample.entity.CSuccess;

@Mapper
public interface CSuccessDao {
	
	@Select("select * from cSuccess")
	public List<CSuccess> getList();
	
	@Insert("insert into cSuccess values(default, default, #{cid}, #{uid})")
	void insert(CSuccess cs);
	
	@Select("SELECT SUM(camount) AS sumToday "
			+ "FROM cSuccess AS s "
			+ "JOIN challenge AS c "
			+ "ON c.cid = s.cid "
			+ "WHERE CAST(s.sucDate AS DATE) = CURDATE() "
			+ "GROUP BY s.uid "
			+ "HAVING uid = #{uid}")
	public int getTodaySum(String uid);
	
	@Select("SELECT SUM(camount) AS sumWeek, DATE_FORMAT(DATE_ADD(NOW(), INTERVAL -1 WEEK), \"%Y-%m-%d\") AS startDate "
			+ "FROM cSuccess AS s "
			+ "JOIN challenge AS c "
			+ "ON c.cid = s.cid "
			+ "WHERE CAST(s.sucDate AS DATE) BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK) AND NOW() "
			+ "and uid = #{uid}")
	public int getWeekSum(String uid, String startDate);
	
	
	@Select("SELECT SUM(camount) AS sumMonth, DATE_FORMAT(DATE_ADD(NOW(), INTERVAL -1 MONTH), \"%Y-%m-%d\") AS startDate "
			+ "FROM cSuccess AS s "
			+ "JOIN challenge AS c "
			+ "ON c.cid = s.cid "
			+ "WHERE CAST(s.sucDate AS DATE) BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH) AND NOW() "
			+ "and uid = #{uid}")
	public int getMonthSum(String uid, String startDate);
	
}
 