package com.robosh.ejournal.data.dto.parent;

import com.robosh.ejournal.data.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ParentDto extends UserDto {

    private List<Long> studentList;

    @Builder
    protected ParentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            List<Long> studentList
    ) {
        super(id, firstName, secondName, lastName, email, phone);
        this.studentList = studentList;
    }
}
