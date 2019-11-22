package com.chidha.rps.service;


import com.chidha.rps.data.SchoolFeesDetailsRepository;
import com.chidha.rps.entity.SchoolFeesDetailsEntity;
import com.chidha.rps.model.SchoolFeesDetails;
import com.chidha.rps.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolFeesDetailsService {

    @Autowired
    private SchoolFeesDetailsRepository schoolFeesDetailsRepository;

    @Autowired
    private ModelUtils<SchoolFeesDetailsEntity, SchoolFeesDetails> modelUtils;


    public SchoolFeesDetails createSchoolFees(SchoolFeesDetails schoolFeesDetails){
        SchoolFeesDetailsEntity schoolFeesDetailsEntity = modelUtils.convertToEntity(schoolFeesDetails, SchoolFeesDetailsEntity.class);
        schoolFeesDetailsEntity = schoolFeesDetailsRepository.save(schoolFeesDetailsEntity);
        return modelUtils.convertTDTO(schoolFeesDetailsEntity, SchoolFeesDetails.class);
    }

    public SchoolFeesDetails updateSchoolDetails(SchoolFeesDetails schoolFeesDetails,  String id){
        schoolFeesDetails.setStandard(id);
        SchoolFeesDetailsEntity schoolFeesDetailsEntity = modelUtils.convertToEntity(schoolFeesDetails, SchoolFeesDetailsEntity.class);
        schoolFeesDetailsEntity = schoolFeesDetailsRepository.save(schoolFeesDetailsEntity);
        return modelUtils.convertTDTO(schoolFeesDetailsEntity, SchoolFeesDetails.class);
    }

    public SchoolFeesDetails getSchoolFeesDetails(String id){
        SchoolFeesDetailsEntity schoolFeesDetailsEntity = schoolFeesDetailsRepository.findById(id).get();
        return modelUtils.convertTDTO(schoolFeesDetailsEntity, SchoolFeesDetails.class);

    }

    public List<SchoolFeesDetails> getAllSchoolFeeDetails() {
        List<SchoolFeesDetails> schoolFeesDetails = new ArrayList<>();
        schoolFeesDetailsRepository.findAll().iterator().forEachRemaining(schoolFeesDetailsEntity -> schoolFeesDetails.add(modelUtils.convertTDTO(schoolFeesDetailsEntity, SchoolFeesDetails.class)));
        return schoolFeesDetails;
    }

}
