package com.robosh.ejournal.dto;

import com.robosh.ejournal.entity.admin.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private SchoolWithDirectorDTO school;

    private AdminRole adminRole;
}
