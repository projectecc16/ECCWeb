package com.eccweb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccweb.entity.Production;
import com.eccweb.repository.ProductionRepository;
import com.eccweb.service.ProductionService;
import com.eccweb.service.exception.DoesNotExistException;
@Service(value="productionService")
@Transactional
public class ProductionServiceImpl implements ProductionService {
	@Autowired
    private ProductionRepository productionRepository;

	@Override
	public List<Production> findAllProduction() {
		return productionRepository.findAll();
	}

	@Override
	public Production findProduction(Long id) {
		return productionRepository.findOne(id);
	}

	@Override
	public Production createProduction(Production data) {
		return productionRepository.save(data);
	}

	@Override
	public Production updateProduction(Production data) {
		Production saveData = productionRepository.findOne(data.getId());
		if(saveData == null)
        {
            throw new DoesNotExistException();
        }
		saveData.setMachine(data.getMachine());
		saveData.setNoOfJobs(data.getNoOfJobs());
		saveData.setNoOfWorkers(data.getNoOfWorkers());
		saveData.setPowerConception(data.getPowerConception());
		saveData.setServiceEngineer(data.getServiceEngineer());
		return productionRepository.save(saveData);
	}

	@Override
	public void deleteProduction(Long id) {
		Production prod = productionRepository.findOne(id);
        if(prod == null)
        {
            throw new DoesNotExistException();
        }
        productionRepository.delete(prod);
	}

}
