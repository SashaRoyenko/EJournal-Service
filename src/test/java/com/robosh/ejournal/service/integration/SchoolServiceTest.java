package com.robosh.ejournal.service.integration;

import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SchoolServiceTest {

    private final int PAGE_SIZE = 3;

    @Autowired
    private SchoolService schoolService;

    @Sql("classpath:schoolData.sql")
    @Test
    void should_returnCorrectNumberOfEntities_When_GivenPageable(){
        List<SchoolInfoDto> schools = schoolService.findPaginated(0, PAGE_SIZE);
        assertEquals(PAGE_SIZE, schools.size());
        schools = schoolService.findPaginated(2, PAGE_SIZE);
        assertEquals(PAGE_SIZE - 1, schools.size());
    }
}
