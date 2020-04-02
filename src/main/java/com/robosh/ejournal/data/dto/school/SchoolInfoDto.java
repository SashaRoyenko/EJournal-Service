package com.robosh.ejournal.data.dto.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolInfoDto {

    private Long id;

    private String name;

    private String url;

    private String department;

    private String region;

    private String locality;
}
