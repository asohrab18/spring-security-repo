package com.easybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easybytes.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	List<Customer> findByEmail(String email);

}