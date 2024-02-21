package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.CandiesOrderLine;
import org.springframework.data.repository.CrudRepository;

public interface IOrderLineRepository extends CrudRepository<CandiesOrderLine, Long> {
}
