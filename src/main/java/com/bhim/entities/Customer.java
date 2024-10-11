package com.bhim.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phno")
	private String phoneNo;

	@Column(name = "date_created")
	@CreationTimestamp
	private LocalDate dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private LocalDate lastUpdated;

}