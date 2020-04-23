package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.service.StudentService;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    @ApiOperation("Get student by Id")
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @ApiOperation("Save new student")
    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody SaveStudentDto student) {
        ValidatorProcessor.validate(student);
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @ApiOperation("Update student")
    @PutMapping
    public StudentDto updateStudent(@RequestBody SaveStudentDto updateStudent) {
        return studentService.update(updateStudent);
    }
}
