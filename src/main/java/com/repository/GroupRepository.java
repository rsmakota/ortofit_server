package com.repository;

import com.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "group", path = "group")
public interface GroupRepository extends CrudRepository<Group, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
