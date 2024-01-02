package com.easybytes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easybytes.entity.Cards;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

	List<Cards> findByCustomerId(int customerId);

}