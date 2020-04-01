package com.robosh.ejournal.data.dto.admin;

import com.robosh.ejournal.data.dto.school.SchoolDTO;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfoDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private SchoolDTO school;

    private AdminRole adminRole;
}
