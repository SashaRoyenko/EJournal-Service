package com.robosh.ejournal.data.dto.school;

import com.robosh.ejournal.data.dto.director.DirectorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolWithDirectorDto extends SchoolDto {

    private DirectorDto director;

    @Builder(builderMethodName = "schoolWithDirectorBuilder")
    private SchoolWithDirectorDto(Long id, String name, String url, String department, String region, String locality, DirectorDto director) {
        super(id, name, url, department, region, locality);
        this.director = director;
    }
}
