package com.robosh.ejournal.data.dto.admin;

import com.robosh.ejournal.data.dto.school.SchoolDto;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfoDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private SchoolDto school;

    private AdminRole adminRole;
}
