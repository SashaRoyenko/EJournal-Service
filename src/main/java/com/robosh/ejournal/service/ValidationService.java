package com.robosh.ejournal.service;

import com.robosh.ejournal.data.repository.ValidationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationService {

    private final ValidationRepository validationRepository;

    public boolean isUnique(String table, String column, String value) {
        return validationRepository.isUnique(table, column, value);
    }

}
