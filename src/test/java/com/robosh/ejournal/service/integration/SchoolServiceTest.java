package com.robosh.ejournal.service.integration;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.SettlementType;
import com.robosh.ejournal.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.robosh.ejournal.data.DummyData.ANY_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SchoolServiceTest {

    private final int PAGE_SIZE = 3;

    @Autowired
    private SchoolService schoolService;

    @Test
    void should_returnCorrectNumberOfEntities_When_GivenPageable(){
        for(SaveSchoolDto school : getSaveSchoolDtos(PAGE_SIZE * 3 - 1)){
            schoolService.save(school);
        }
        List<SchoolInfoDto> schools = schoolService.findPaginated(0, PAGE_SIZE);
        assertEquals(PAGE_SIZE, schools.size());
        schools = schoolService.findPaginated(2, PAGE_SIZE);
        assertEquals(PAGE_SIZE - 1, schools.size());
    }

    private List<SaveSchoolDto> getSaveSchoolDtos(int number){
        List<SaveSchoolDto> saveSchoolDtos = new ArrayList<>();
        for(int i = 0; i < number; i++){
            saveSchoolDtos.add(SaveSchoolDto.builder()
                    .address(ANY_STRING)
                    .name(ANY_STRING)
                    .region(ANY_STRING)
                    .settlementName(ANY_STRING)
                    .settlementType(SettlementType.CITY)
                    .url(ANY_STRING)
                    .build());
        }
        return saveSchoolDtos;
    }
}