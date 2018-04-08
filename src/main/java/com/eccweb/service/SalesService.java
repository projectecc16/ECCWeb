package com.eccweb.service;

import java.util.List;

import com.eccweb.entity.Production;
import com.eccweb.entity.Sales;

public interface SalesService {
	public List<Sales> findAll();
    public Sales find(Long id);
    public Sales create(Sales data);
    public Sales update(Sales data);
    public void delete(Long id);
}
