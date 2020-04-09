package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @ApiOperation(value = "Save school")
    @PostMapping
    public ResponseEntity<SchoolInfoDto> saveSchool(@RequestBody SaveSchoolDto dto) {
        SchoolInfoDto schoolInfoDto = schoolService.save(dto);
        return new ResponseEntity<>(schoolInfoDto, HttpStatus.CREATED);
    }
}
