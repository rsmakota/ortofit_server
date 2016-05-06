package com.repository;

import com.model.PersonService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "personService", path = "personService")
public interface PersonServiceRepository extends CrudRepository<PersonService, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
