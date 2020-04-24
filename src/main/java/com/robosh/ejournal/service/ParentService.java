package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.entity.Parent;
import com.robosh.ejournal.data.mapping.ParentMapper;
import com.robosh.ejournal.data.repository.ParentRepository;
import com.robosh.ejournal.util.PasswordGenerator;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ParentService {

    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    private final PasswordGenerator passwordGenerator;

    public ParentDto save(SaveParentDto dto){
        Parent parent = parentMapper.fromSaveParentDtoToParent(dto);
        parent.setPassword(passwordGenerator.generateRandomPassword());

        ValidatorProcessor.validate(parent);

        parent = parentRepository.save(parent);
        log.info("Parent saved");
        return parentMapper.fromParentToParentDto(parent);
    }
}
