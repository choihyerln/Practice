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
	
	@Select("select * from users")
	List<User> getList();

	@Select("select * from users where uid=#{uid}")
	User get(String uid);
	
	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, #{email}, default, default)")
	void insert(User u);
	
	@Update("UPDATE users SET pwd = #{pwd}, uname = #{uname}, email = #{email} WHERE uid = #{uid};")
	void update(User u);
	
	@Delete("delete from users where uid=#{uid};")
	void delete(String uid);
	
}
