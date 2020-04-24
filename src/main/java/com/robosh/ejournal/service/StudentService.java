package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.mapping.StudentMapper;
import com.robosh.ejournal.data.repository.StudentRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.util.PasswordGenerator;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PasswordGenerator passwordGenerator;
    private final ModelMapper modelMapper;

    public StudentDto findById(Long id) {
        return studentMapper.fromStudentToStudentDto(findStudentById(id));
    }

    @Transactional
    public StudentDto save(SaveStudentDto dto) {
        dto.setParents(Optional.ofNullable(dto.getParents()).orElse(new ArrayList<>()));
        Student student = studentMapper.fromStudentSaveDtoToStudent(dto);
        student.setPassword(passwordGenerator.generateRandomPassword());

        ValidatorProcessor.validate(student);
        student = studentRepository.save(student);
        log.info("Student saved");
        return studentMapper.fromStudentToStudentDto(student);
    }

    public StudentDto update(SaveStudentDto dto) {
        dto.setParents(Optional.ofNullable(dto.getParents()).orElse(new ArrayList<>()));
        Student currentStudent = findStudentById(dto.getId());
        Student updateStudent = studentMapper.fromStudentSaveDtoToStudent(dto);

        fixMapping(dto, updateStudent);
        modelMapper.map(updateStudent, currentStudent);
        ValidatorProcessor.validate(currentStudent);

        currentStudent = studentRepository.save(currentStudent);
        log.info("Student updated");
        return studentMapper.fromStudentToStudentDto(currentStudent);
    }

    public List<StudentDto> findBySchoolId(Long schoolId, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> paged = studentRepository.findAllBySchoolId(schoolId, pageable);
        return studentMapper.fromStudentsToStudentsDto(paged.getContent());
    }

    private Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    private void fixMapping(SaveStudentDto dto, Student student) {
        if (dto.getGroupId() == null) {
            student.setGroup(null);
        }
        if (dto.getSchoolId() == null) {
            student.setSchool(null);
        }
    }


}
