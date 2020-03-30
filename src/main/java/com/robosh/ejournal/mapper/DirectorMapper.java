package com.robosh.ejournal.mapper;

import com.robosh.ejournal.dto.DirectorDTO;
import com.robosh.ejournal.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorMapper {

    DirectorMapper directorMapper = Mappers.getMapper(DirectorMapper.class);

    DirectorDTO fromDirectorToDirectorDTO(Director director);
}
