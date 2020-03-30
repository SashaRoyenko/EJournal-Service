package com.robosh.ejournal.data.dto.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolInfoWithoutDirectorDto {

    private Long id;

    @NotBlank
    private String name;

    private String url;

    @NotBlank
    private String department;

    @NotBlank
    private String region;

    @NotBlank
    private String locality;

}
