package com.repository;

import com.model.City;
import com.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends CrudRepository<City, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
