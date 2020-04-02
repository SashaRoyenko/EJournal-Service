package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.mapping.StudentMapper;
import com.robosh.ejournal.data.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDto findById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return studentMapper.fromStudentToStudentDto(optionalStudent.get());
        } else {
            return null;
        }
    }
}
