package com.eccweb.service;

import java.util.List;

import com.eccweb.entity.HR;

public interface HRService {
	public List<HR> findAll();
    public HR find(Long id);
    public HR create(HR data);
    public HR update(HR data);
    public void delete(Long id);
}
