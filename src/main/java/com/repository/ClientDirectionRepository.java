package com.repository;

import com.model.ClientDirection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "clientDirection", path = "clientDirection")
public interface ClientDirectionRepository extends CrudRepository<ClientDirection, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
