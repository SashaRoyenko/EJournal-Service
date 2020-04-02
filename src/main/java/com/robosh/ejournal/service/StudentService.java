package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.mapping.StudentMapper;
import com.robosh.ejournal.data.repository.StudentRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDto findById(Long id){
            return studentMapper.fromStudentToStudentDto(
                    studentRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException("User", "id", id)));

    }
}
