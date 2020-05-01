package com.robosh.ejournal.service;

import com.robosh.ejournal.data.mapping.TeacherMapper;
import com.robosh.ejournal.data.repository.TeacherRepository;
import com.robosh.ejournal.util.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final PasswordGenerator passwordGenerator;
    private final ModelMapper modelMapper;
    private final TeacherMapper teacherMapper;

}
