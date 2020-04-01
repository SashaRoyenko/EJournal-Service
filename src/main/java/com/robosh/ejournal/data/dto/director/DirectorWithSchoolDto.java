package com.robosh.ejournal.data.dto.director;

import com.robosh.ejournal.data.dto.school.SchoolDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorWithSchoolDto extends DirectorDto {
    private SchoolDto school;

    @Builder(builderMethodName = "directorWithSchoolBuilder")
    private DirectorWithSchoolDto(Long id, String firstName, String secondName, String lastName, String email, String phone, SchoolDto school) {
        super(id, firstName, secondName, lastName, email, phone);
        this.school = school;
    }
}
