package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.CandiesOrderLine;
import org.springframework.data.repository.CrudRepository;

public interface ICandyOrderLineRepository extends CrudRepository<CandiesOrderLine, Long> {
}
