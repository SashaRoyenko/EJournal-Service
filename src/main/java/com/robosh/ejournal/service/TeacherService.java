package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.data.entity.Teacher;
import com.robosh.ejournal.data.mapping.TeacherMapper;
import com.robosh.ejournal.data.repository.TeacherRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.util.PasswordGenerator;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final PasswordGenerator passwordGenerator;
    private final ModelMapper modelMapper;
    private final TeacherMapper teacherMapper;

    public TeacherDto save(SaveTeacherDto dto) {
        Teacher teacher = teacherMapper.fromSaveTeacherDtoToTeacher(dto);
        fixMapping(dto, teacher);
        teacher.setPassword(passwordGenerator.generateRandomPassword());

        ValidatorProcessor.validate(teacher);

        teacher = teacherRepository.save(teacher);
        log.info("Teacher saved");
        return teacherMapper.fromTeacherToTeacherDto(teacher);
    }

    public TeacherDto findById(Long id) {
        return teacherMapper.fromTeacherToTeacherDto(findTeacherById(id));
    }

    private void fixMapping(SaveTeacherDto dto, Teacher teacher) {
        if (dto.getGroupId() == null) {
            teacher.setGroup(null);
        }
    }

    private Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));
    }
}
