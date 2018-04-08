package com.eccweb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccweb.entity.Finance;
import com.eccweb.repository.FinanceRepository;
import com.eccweb.service.FinanceService;
import com.eccweb.service.exception.DoesNotExistException;
@Service(value="financeService")
@Transactional
public class FinanceServiceImpl implements FinanceService {
	@Autowired
    private FinanceRepository financeRepository;

	@Override
	public List<Finance> findAll() {
		return financeRepository.findAll();
	}

	@Override
	public Finance find(Long id) {
		return financeRepository.findOne(id);
	}

	@Override
	public Finance create(Finance data) {
		return financeRepository.save(data);
	}

	@Override
	public Finance update(Finance data) {
		Finance saveData = financeRepository.findOne(data.getId());
		if(saveData == null)
        {
            throw new DoesNotExistException();
        }
		saveData.setBudget(data.getBudget());
		saveData.setCashInBank(data.getCashInBank());
		saveData.setOverdraft(data.getOverdraft());
		saveData.setProjectName(data.getProjectName());
    	saveData.setWages(data.getWages());
    	
		return financeRepository.save(saveData);
	}

	@Override
	public void delete(Long id) {
		Finance finance = financeRepository.findOne(id);
        if(finance == null)
        {
            throw new DoesNotExistException();
        }
        financeRepository.delete(finance);
	}

}
