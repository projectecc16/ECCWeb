package com.eccweb.service;

import java.util.List;

import com.eccweb.entity.Production;

public interface ProductionService {
	public List<Production> findAllProduction();
    public Production findProduction(Long id);
    public Production createProduction(Production data);
    public Production updateProduction(Production data);
    public void deleteProduction(Long id);
}
