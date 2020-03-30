package com.robosh.ejournal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO {

    protected Long id;

    protected String name;

    protected String url;

    protected String department;

    protected String region;

    protected String locality;
}
