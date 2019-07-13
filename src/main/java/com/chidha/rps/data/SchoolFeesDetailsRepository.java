package com.chidha.rps.data;

import com.chidha.rps.entity.SchoolFeesDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolFeesDetailsRepository extends CrudRepository<SchoolFeesDetailsEntity, String> {
}
