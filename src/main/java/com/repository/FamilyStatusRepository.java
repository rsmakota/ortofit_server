package com.repository;

import com.model.City;
import com.model.FamilyStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "familyStatus", path = "familyStatus")
public interface FamilyStatusRepository extends CrudRepository<FamilyStatus, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
