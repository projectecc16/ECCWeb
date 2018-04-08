package com.eccweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eccweb.entity.HR;

public interface HRRepository extends JpaRepository<HR, Long> {	
	//Production findOne(Long id);
	//Production save(Production production);
    //List<Production> findAll();
//    void delete(Production production);
//    public Production updateProduction(Production data);
}
