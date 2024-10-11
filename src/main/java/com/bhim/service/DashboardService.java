package com.bhim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhim.dto.DashboardDTO;
import com.bhim.repository.CustomerRepository;
import com.bhim.repository.OrderRepository;
import com.bhim.repository.ProductRepository;

@Service
public class DashboardService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepo;

	public DashboardDTO fetchDashboardValues() {
		DashboardDTO dashboardDTO = new DashboardDTO();

		dashboardDTO.setProductCount(productRepo.count());
		dashboardDTO.setCustomersCount(customerRepo.count());
		dashboardDTO.setAmountCollected(orderRepo.findTotalAmount());
		dashboardDTO.setOrdersCount(orderRepo.count());

		return dashboardDTO;
	}

}
