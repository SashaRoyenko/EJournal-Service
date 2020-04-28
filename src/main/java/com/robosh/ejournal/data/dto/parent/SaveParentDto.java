package com.robosh.ejournal.data.dto.parent;

import com.robosh.ejournal.data.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Data
public class SaveParentDto extends UserDto {

    @NotNull
    private List<Long> studentList;

    private Long schoolId;

    @Builder
    private SaveParentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            List<Long> studentList,
            Long schoolId) {
        super(id, firstName, secondName, lastName, email, phone);
        this.studentList = studentList;
        this.schoolId = schoolId;
    }
}
