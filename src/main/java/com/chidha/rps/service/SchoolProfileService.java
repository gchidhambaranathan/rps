package com.chidha.rps.service;

import com.chidha.rps.data.SchoolProfileRepository;
import com.chidha.rps.entity.SchoolAddressEntity;
import com.chidha.rps.entity.SchoolProfileEntity;
import com.chidha.rps.model.SchoolProfile;
import com.chidha.rps.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolProfileService {

    @Autowired
    private SchoolProfileRepository schoolProfileRepository;

    @Autowired
    private ModelUtils<SchoolProfileEntity, SchoolProfile> modelUtils;


    public SchoolProfile updateSchoolInfo(SchoolProfile schoolProfile, String id){
        schoolProfile.setSchoolId(id);
        SchoolProfileEntity schoolProfileEntity = modelUtils.convertToEntity(schoolProfile, SchoolProfileEntity.class);
        SchoolAddressEntity schoolAddressEntity = new SchoolAddressEntity();
        schoolAddressEntity.setStreet(schoolProfile.getSchoolAddress().getStreet());
        schoolAddressEntity.setPincode(schoolProfile.getSchoolAddress().getPincode());
        schoolProfileEntity.setSchoolAddressEntity(schoolAddressEntity);
        schoolProfileEntity = schoolProfileRepository.save(schoolProfileEntity);
        return modelUtils.convertTDTO(schoolProfileEntity, SchoolProfile.class);
    }

    public SchoolProfile getSchoolInfo(String id){
        SchoolProfileEntity schoolProfileEntity = schoolProfileRepository.findById(id).get();
        return modelUtils.convertTDTO(schoolProfileEntity,SchoolProfile.class);
    }
}
