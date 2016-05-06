package com.repository;

import com.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "schedule", path = "schedule")
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}
