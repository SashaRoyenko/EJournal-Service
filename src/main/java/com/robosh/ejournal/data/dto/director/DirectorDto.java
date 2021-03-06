package com.robosh.ejournal.data.dto.director;


import com.robosh.ejournal.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DirectorDto extends UserDto {

    @Builder
    protected DirectorDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone
    ) {
        super(id, firstName, secondName, lastName, email, phone);
    }
}
