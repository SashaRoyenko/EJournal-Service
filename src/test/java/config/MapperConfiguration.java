package config;

import com.robosh.ejournal.data.mapping.admin.AdminInfoMapper;
import com.robosh.ejournal.data.mapping.admin.UpdateAdminMapper;
import com.robosh.ejournal.data.mapping.school.SchoolInfoWithoutDirectorDtoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MapperConfiguration {

    @Bean
    public AdminInfoMapper getAdminInfoMapper() {
        return Mappers.getMapper(AdminInfoMapper.class);
    }

    @Bean
    public UpdateAdminMapper getUpdateAdminMapper() {
        return Mappers.getMapper(UpdateAdminMapper.class);
    }

    @Bean
    public SchoolInfoWithoutDirectorDtoMapper getSchoolInfoWithoutDirectorDtoMapper() {
        return Mappers.getMapper(SchoolInfoWithoutDirectorDtoMapper.class);
    }
}
