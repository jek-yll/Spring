package org.example.exo1_spring_data_rest.repository;

import org.example.exo1_spring_data_rest.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "candy", collectionResourceRel = "candies")
public interface ICandyRepository extends CrudRepository<Candy, Long> {
    @RestResource(path = "searchname")
    List<Candy> findAllByName(@Param("name")String name);
    List<Candy> findAllByMagicEffect(String magicEffect);
    List<Candy> findAllByPriceBetween(Double minPrice,Double maxPrice);
    @RestResource(exported = false)
    void deleteById(Long id);
}
