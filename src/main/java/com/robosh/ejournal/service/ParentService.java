package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.dto.parent.UpdateParentDto;
import com.robosh.ejournal.data.entity.Parent;
import com.robosh.ejournal.data.mapping.ParentMapper;
import com.robosh.ejournal.data.repository.ParentRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.util.PasswordGenerator;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ParentService {

    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    private final PasswordGenerator passwordGenerator;
    private final ModelMapper modelMapper;

    public ParentDto save(SaveParentDto dto) {
        Parent parent = parentMapper.fromSaveParentDtoToParent(dto);
        parent.setPassword(passwordGenerator.generateRandomPassword());

        ValidatorProcessor.validate(parent);

        parent = parentRepository.save(parent);
        log.info("Parent saved");
        return parentMapper.fromParentToParentDto(parent);
    }

    public ParentDto update(UpdateParentDto dto) {
        dto.setStudentList(Optional.ofNullable(dto.getStudentList()).orElse(new ArrayList<>()));

        Parent currentParent = findParentById(dto.getId());
        Parent updateParent = parentMapper.fromUpdateParentDtoToParent(dto);

        fixMapping(dto, updateParent);
        modelMapper.map(updateParent, currentParent);
        ValidatorProcessor.validate(currentParent);

        currentParent = parentRepository.save(currentParent);
        log.info("Parent updated");
        return parentMapper.fromParentToParentDto(currentParent);

    }

    public ParentDto findById(Long id) {
        return parentMapper.fromParentToParentDto(findParentById(id));
    }

    private Parent findParentById(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent", "id", id));
    }

    private void fixMapping(UpdateParentDto dto, Parent mapped){
        if(dto.getSchoolId() == null){
            mapped.setSchool(null);
        }
    }
}
