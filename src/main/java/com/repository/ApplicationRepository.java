package com.repository;

import com.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "application", path = "application")
public interface ApplicationRepository extends CrudRepository<Application, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
