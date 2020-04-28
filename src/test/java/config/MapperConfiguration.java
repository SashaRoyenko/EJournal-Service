package config;

import com.robosh.ejournal.data.mapping.AdminMapper;
import com.robosh.ejournal.data.mapping.ParentMapper;
import com.robosh.ejournal.data.mapping.SchoolMapper;
import com.robosh.ejournal.data.mapping.StudentMapper;
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

    @Bean
    public StudentMapper getStudentMapper(){return Mappers.getMapper(StudentMapper.class);}

    @Bean
    public ParentMapper getParentMapper(){return Mappers.getMapper(ParentMapper.class);}
}
