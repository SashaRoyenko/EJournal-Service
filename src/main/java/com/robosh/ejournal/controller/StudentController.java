package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.dto.student.StudentSaveDto;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    @ApiOperation("Get student by Id")
    @ExceptionHandler({ResourceNotFoundException.class})
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @ApiOperation("Save new student")
    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentSaveDto student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }
}
