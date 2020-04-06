package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.mapping.StudentMapper;
import com.robosh.ejournal.data.repository.StudentRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDto findById(Long id) {
        return studentMapper.fromStudentToStudentDto(
                studentRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id)));
    }

    public StudentDto save(SaveStudentDto dto) {
        dto.setParents(Optional.ofNullable(dto.getParents()).orElse(new ArrayList<>()));
        StudentDto studentDto = studentMapper.fromStudentToStudentDto(
                studentRepository.save(
                        studentMapper.fromStudentSaveDtoToStudent(dto))
        );
        log.info("Student saved");
        return studentDto;
    }
}
