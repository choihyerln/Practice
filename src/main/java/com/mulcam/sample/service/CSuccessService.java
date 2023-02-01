package com.mulcam.sample.service;

import java.util.List;

import com.mulcam.sample.entity.CSuccess;

public interface CSuccessService {
	
	void insert (CSuccess c);
	
	List<CSuccess> getList();
}
