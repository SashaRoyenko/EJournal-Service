package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid SaveTeacherDto teacher) {
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public TeacherDto findTeacherById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @GetMapping
    public List<TeacherDto> findTeachersBySchoolId(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("schoolId") Long schoolId
    ) {
        return teacherService.findAllBySchoolId(schoolId, page, size);
    }

    @PutMapping
    public TeacherDto updateTeacher(@RequestBody @Valid SaveTeacherDto dto) {
        return teacherService.updateTeacher(dto);
    }
}
