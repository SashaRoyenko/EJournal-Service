package com.robosh.ejournal.config;

import com.robosh.ejournal.data.mapping.SchoolMapper;
import com.robosh.ejournal.data.mapping.admin.AdminMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MapperConfiguration {
    @Bean
    public AdminMapper getAdminMapper() {
        return Mappers.getMapper(AdminMapper.class);
    }

    @Bean
    public SchoolMapper getSchoolMapper() {
        return Mappers.getMapper(SchoolMapper.class);
    }
}
