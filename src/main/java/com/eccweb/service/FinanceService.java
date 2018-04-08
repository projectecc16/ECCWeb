package com.eccweb.service;

import java.util.List;

import com.eccweb.entity.Finance;

public interface FinanceService {
	public List<Finance> findAll();
    public Finance find(Long id);
    public Finance create(Finance data);
    public Finance update(Finance data);
    public void delete(Long id);
}
