package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parents")
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    public ResponseEntity<ParentDto> saveParent(@RequestBody SaveParentDto dto) {
        return new ResponseEntity<>(parentService.save(dto), HttpStatus.CREATED);
    }
}
