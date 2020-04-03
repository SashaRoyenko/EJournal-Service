package com.robosh.ejournal.data.dto.student;

import com.robosh.ejournal.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSaveDto extends UserDto {

    private Long groupId;
}
