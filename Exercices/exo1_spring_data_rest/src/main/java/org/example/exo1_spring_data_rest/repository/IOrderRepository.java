package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.CandiesOrder;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<CandiesOrder, Long> {
}
