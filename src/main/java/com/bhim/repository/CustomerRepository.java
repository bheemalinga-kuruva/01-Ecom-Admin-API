package com.bhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhim.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
