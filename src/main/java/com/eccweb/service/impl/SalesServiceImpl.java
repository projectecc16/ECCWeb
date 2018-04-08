package com.eccweb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccweb.entity.Sales;
import com.eccweb.repository.SalesRepository;
import com.eccweb.service.SalesService;
import com.eccweb.service.exception.DoesNotExistException;
@Service(value="salesService")
@Transactional
public class SalesServiceImpl implements SalesService {
	@Autowired
    private SalesRepository salesRepository;

	@Override
	public List<Sales> findAll() {
		return salesRepository.findAll();
	}

	@Override
	public Sales find(Long id) {
		return salesRepository.findOne(id);
	}

	@Override
	public Sales create(Sales data) {
		return salesRepository.save(data);
	}

	@Override
	public Sales update(Sales data) {
		Sales saveData = salesRepository.findOne(data.getId());
		if(saveData == null)
        {
            throw new DoesNotExistException();
        }
		saveData.setDeliveryDetail(data.getDeliveryDetail());
		saveData.setPreBookingDetail(data.getPreBookingDetail());
		saveData.setProductName(data.getProductName());
		saveData.setQuantity(data.getQuantity());
		saveData.setYearOfProd(data.getYearOfProd());
		return salesRepository.save(saveData);
	}

	@Override
	public void delete(Long id) {
		Sales sales = salesRepository.findOne(id);
        if(sales == null)
        {
            throw new DoesNotExistException();
        }
        salesRepository.delete(sales);
	}

}
