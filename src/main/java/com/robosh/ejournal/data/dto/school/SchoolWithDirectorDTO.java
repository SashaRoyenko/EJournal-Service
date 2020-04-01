package com.robosh.ejournal.data.dto.school;

import com.robosh.ejournal.data.dto.director.DirectorDTO;
import com.robosh.ejournal.data.dto.school.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolWithDirectorDTO extends SchoolDTO {

    private DirectorDTO director;

    @Builder(builderMethodName = "schoolWithDirectorBuilder")
    private SchoolWithDirectorDTO(Long id, String name, String url, String department, String region, String locality, DirectorDTO director) {
        super(id, name, url, department, region, locality);
        this.director = director;
    }
}
