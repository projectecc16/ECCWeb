package com.eccweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eccweb.entity.Production;

public interface ProductionRepository extends JpaRepository<Production, Long> {	
	//Production findOne(Long id);
	//Production save(Production production);
    //List<Production> findAll();
//    void delete(Production production);
//    public Production updateProduction(Production data);
}
