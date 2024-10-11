package com.bhim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bhim.dto.ReportDTO;
import com.bhim.entities.Order;
import com.bhim.repository.OrderRepository;
import com.bhim.specification.ReportSpecification;

@Service
public class ReportService {

	@Autowired
	private OrderRepository orderRepo;

	public List<Order> filterOrders(ReportDTO reportDTO) {
		Specification<Order> specification = Specification
				.where(ReportSpecification.hasCustomerEmail(reportDTO.getCustomerEmail()))
				.and(ReportSpecification.hasStartDate(reportDTO.getStartDate()))
				.and(ReportSpecification.hasEndDate(reportDTO.getEndDate()));

		return orderRepo.findAll(specification);
	}
}