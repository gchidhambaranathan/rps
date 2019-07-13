package com.chidha.rps.data;


import com.chidha.rps.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentEntityRepository extends CrudRepository<StudentEntity, Long> {

    List<StudentEntity> findStudentEntitiesByAdmissionNumberAndStandard(long admissionNumber, String standard);
}
