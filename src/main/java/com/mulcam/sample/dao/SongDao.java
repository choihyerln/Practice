package com.mulcam.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.sample.entity.Song;

@Mapper
public interface SongDao {
	
	@Select("select * from song")
	public List<Song> getSongList();

}
