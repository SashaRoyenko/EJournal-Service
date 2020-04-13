package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.mapping.SchoolMapper;
import com.robosh.ejournal.data.repository.SchoolRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolInfoDto save(SaveSchoolDto saveSchoolDto) {
        School school = schoolMapper.fromSaveSchoolDtoToSchool(saveSchoolDto);

        ValidatorProcessor.validate(school);

        school = schoolRepository.save(school);
        log.info("School saved");

        return schoolMapper.fromSchoolToSchoolInfoDto(school);
    }

    public SchoolInfoDto findById(Long id){
        School school = schoolRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("School", "id", id));
        return schoolMapper.fromSchoolToSchoolInfoDto(school);
    }
}
