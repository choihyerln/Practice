package com.mulcam.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.sample.entity.User;

@Mapper
public interface UserDao {
	
	@Select("select * from user")
	List<User> getList();

	@Select("select * from user where id=#{id}")
	User get(String id);
	
	@Insert("insert into user values(default, #{id}, #{pwd}, #{nickname}, #{email}, #{tel}, #{pay}, #{departures}, #{arrivals}, #{vehicles})")
	void insert(User u);
		
//	@Delete("delete from user where id=#{id};")
//	void delete(String id);
	
}
