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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<TeacherDto> findAllBySchoolId(Long id, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> paged = teacherRepository.findAllBySchoolId(id, pageable);
        return teacherMapper.fromTeachersToTeachersDto(paged.getContent());
    }


    public TeacherDto updateTeacher(SaveTeacherDto dto) {
        Teacher currentTeacher = findTeacherById(dto.getId());
        Teacher updateTeacher = teacherMapper.fromSaveTeacherDtoToTeacher(dto);

        fixMapping(dto, updateTeacher);
        modelMapper.map(updateTeacher, currentTeacher);
        ValidatorProcessor.validate(currentTeacher);

        currentTeacher = teacherRepository.save(currentTeacher);
        log.info("teacher updated");
        return teacherMapper.fromTeacherToTeacherDto(currentTeacher);
    }
    private void fixMapping(SaveTeacherDto dto, Teacher teacher) {
        if (dto.getGroupId() == null) {
            teacher.setGroup(null);
        }
        if (dto.getSchoolId() == null) {
            teacher.setSchool(null);
        }
    }

    private Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));
    }
}
