package com.repository;

import com.model.AppReminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "appReminder", path = "appReminder")
public interface AppReminderRepository extends CrudRepository<AppReminder, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
