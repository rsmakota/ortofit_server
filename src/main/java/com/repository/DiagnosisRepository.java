package com.repository;

import com.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "diagnosis", path = "diagnosis")
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
