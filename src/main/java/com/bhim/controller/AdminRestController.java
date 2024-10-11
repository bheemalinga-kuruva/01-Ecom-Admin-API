package com.bhim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhim.dto.DashboardDTO;
import com.bhim.dto.ReportDTO;
import com.bhim.entities.Order;
import com.bhim.service.DashboardService;
import com.bhim.service.ReportService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/api/admin")
public class AdminRestController {

	@Autowired
	public DashboardService dashboardService;

	@Autowired
	public ReportService reportService;

	@GetMapping(value = "/dashboard")
	public ResponseEntity<DashboardDTO> getDashboardData() {
		DashboardDTO dashboardDTO = dashboardService.fetchDashboardValues();
		return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/filter")
	public List<Order> filterOrders(@RequestBody ReportDTO reportDTO) {
		return reportService.filterOrders(reportDTO);
	}
}
