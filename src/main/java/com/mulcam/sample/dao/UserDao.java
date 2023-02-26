package com.mulcam.sample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.sample.entity.User;

@Mapper
public interface UserDAO {

	@Select("SELECT * FROM user WHERE uid=#{uid}")
	User findByUid(Long uid);
	
	@Select("SELECT * FROM user WHERE id=#{id} and isDeleted=0")		// 탈퇴한 적 없는 회원만 로그인 가능
	User findById(String id);
	
	@Insert("INSERT INTO user VALUES(default, #{uname}, #{id}, #{pwd}, #{nickname}, #{email}, #{tel}, #{birthDate}, #{addr}, #{pay}, #{departures}, #{arrivals}, #{vehicles}, default, #{bank}, #{accountNumber}, #{code})")
	void insert(User u);
	
	/** 아이디 중복 검사 */
	@Select("SELECT COUNT(id) FROM user WHERE id= #{id}")
	int idCheck(String id);
	
	/** 닉네임 중복 검사 */
	@Select("SELECT COUNT(nickname) FROM user WHERE nickname= #{nickname}")
	int nicknameCheck(String nickname);
	
	/** 회원정보 수정 */
	// 비밀번호 수정했을 경우
	@Update("UPDATE user SET pwd=#{pwd} nickname=#{nickname}, email=#{email}, #{tel}, #{birthDate}, #{addr}, #{pay}, #{departures}, #{arrivals}, #{vehicles}, #{bank}, #{accountNumber}, #{code} WHERE uid=#{uid})")
	void update(User u);
	// 비밀번호 수정하지 않았을 경우
	@Update("UPDATE user SET nickname=#{nickname}, email=#{email}, #{tel}, #{birthDate}, #{addr}, #{pay}, #{departures}, #{arrivals}, #{vehicles}, #{bank}, #{accountNumber}, #{code} WHERE uid=#{uid})")
	void updateWithoutPwd(User u);
	
	/** 회원 탈퇴 */
	@Update("UPDATE user SET isDeleted=1 WHERE id=#{id}")
	public void delete(String id);

}