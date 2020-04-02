package com.robosh.ejournal.data.dto.parent;

import com.robosh.ejournal.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ParentDto extends UserDto {

    @Builder
    protected ParentDto(
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
