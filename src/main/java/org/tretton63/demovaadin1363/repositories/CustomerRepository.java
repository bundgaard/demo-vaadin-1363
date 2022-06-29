package org.tretton63.demovaadin1363.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tretton63.demovaadin1363.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
