package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
