package com.chidha.rps.data;

import com.chidha.rps.entity.SchoolProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolProfileRepository extends CrudRepository<SchoolProfileEntity, String> {

}
