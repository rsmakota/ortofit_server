package com.repository;

import com.model.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "service", path = "service")
public interface ServiceRepository extends CrudRepository<Service, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
