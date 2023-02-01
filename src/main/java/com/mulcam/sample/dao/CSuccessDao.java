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
	void insert(CSuccess c);
}
