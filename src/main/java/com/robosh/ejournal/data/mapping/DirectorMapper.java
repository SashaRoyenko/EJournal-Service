package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.director.DirectorDto;
import com.robosh.ejournal.data.entity.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorDto fromDirectorToDirectorDTO(Director director);
}
