package com.repository;

import com.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends CrudRepository<Client, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
