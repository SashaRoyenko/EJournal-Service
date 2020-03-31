package com.robosh.ejournal.data.dto.director;

import com.robosh.ejournal.data.dto.school.SchoolDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorWithSchoolDTO extends DirectorDTO {
    private SchoolDTO school;

    @Builder(builderMethodName = "directorWithSchoolBuilder")
    private DirectorWithSchoolDTO(Long id, String firstName, String secondName, String lastName, String email, String phone, SchoolDTO school) {
        super(id, firstName, secondName, lastName, email, phone);
        this.school = school;
    }
}
