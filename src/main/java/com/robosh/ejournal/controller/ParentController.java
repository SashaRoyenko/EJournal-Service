package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.dto.parent.UpdateParentDto;
import com.robosh.ejournal.service.ParentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parents")
public class ParentController {

    private final ParentService parentService;

    @ApiOperation("Save new parent")
    @PostMapping
    public ResponseEntity<ParentDto> saveParent(@RequestBody @Valid SaveParentDto dto) {
        return new ResponseEntity<>(parentService.save(dto), HttpStatus.CREATED);
    }

    @ApiOperation("Update parent")
    @PutMapping
    public ParentDto updateParent(@RequestBody @Valid UpdateParentDto dto) {
        return parentService.update(dto);
    }

    @ApiOperation("Find parent by id")
    @GetMapping("/{id}")
    public ParentDto getParentById(@PathVariable Long id) {
        return parentService.findById(id);
    }

    @ApiOperation("Find parents by school id")
    @GetMapping
    public List<ParentDto> getAllParentsBySchoolId(
            @RequestParam Long id,
            @RequestParam int page,
            @RequestParam int size
    ){
        return parentService.findAllBySchoolId(id, page, size);
    }
}
