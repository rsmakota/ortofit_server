package com.repository;

import com.model.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "office", path = "office")
public interface OfficeRepository extends CrudRepository<Office, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
