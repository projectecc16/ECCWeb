package com.eccweb.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccweb.entity.HR;
import com.eccweb.repository.HRRepository;
import com.eccweb.service.HRService;
import com.eccweb.service.exception.DoesNotExistException;
@Service(value="hrService")
@Transactional
public class HRServiceImpl implements HRService {
	@Autowired
    private HRRepository hrRepository;

	@Override
	public List<HR> findAll() {
		return hrRepository.findAll();
	}

	@Override
	public HR find(Long id) {
		return hrRepository.findOne(id);
	}

	@Override
	public HR create(HR data) {
		return hrRepository.save(data);
	}

	@Override
	public HR update(HR hr) {
		HR hrRes = hrRepository.findOne(hr.getId());
		if(hrRes == null)
        {
            throw new DoesNotExistException();
        }
		hrRes.setEmployeeDept(hr.getEmployeeDept());
    	hrRes.setEmployeeEmail(hr.getEmployeeEmail());
    	hrRes.setEmployeeName(hr.getEmployeeName());
    	hrRes.setEmployeePhone(hr.getEmployeePhone());
    	hrRes.setEmployeeTitle(hr.getEmployeeTitle());
		return hrRepository.save(hrRes);
	}

	@Override
	public void delete(Long id) {
		HR hr = hrRepository.findOne(id);
        if(hr == null)
        {
            throw new DoesNotExistException();
        }
        hrRepository.delete(hr);
	}

}
