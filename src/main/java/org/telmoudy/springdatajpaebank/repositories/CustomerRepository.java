package org.telmoudy.springdatajpaebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telmoudy.springdatajpaebank.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstNameContainingIgnoreCase(String keyword);
    Optional<Customer> findByEmail(String email);
}
