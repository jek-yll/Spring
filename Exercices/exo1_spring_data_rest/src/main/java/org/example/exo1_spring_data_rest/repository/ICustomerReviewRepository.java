package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.CustomerReview;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerReviewRepository extends CrudRepository<CustomerReview, Long> {
}
