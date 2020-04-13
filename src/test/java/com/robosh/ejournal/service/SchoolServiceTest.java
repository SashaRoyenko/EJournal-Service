package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.entity.SettlementType;
import com.robosh.ejournal.data.repository.SchoolRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import config.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.robosh.ejournal.data.DummyData.ANY_LONG;
import static com.robosh.ejournal.data.DummyData.ANY_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        SchoolService.class,
        MapperConfiguration.class,
})
class SchoolServiceTest {

    @Autowired
    private SchoolService schoolService;

    @MockBean
    private SchoolRepository mockedSchoolRepository;

    @Test
    void should_ReturnSchoolInfoDto_When_SaveSchoolDtoHasValidData() {
        when(mockedSchoolRepository.save(getSchool())).thenReturn(getSchool());

        SchoolInfoDto expectedSchoolDto = getSchoolInfoDto();
        SchoolInfoDto actualSchoolDto = schoolService.save(getSaveSchoolDto());

        assertEquals(expectedSchoolDto, actualSchoolDto);
    }

    @Test
    void should_ReturnSchoolInfoDto_When_RepositoryReturnSchool() {
        when(mockedSchoolRepository.findById(ANY_LONG)).thenReturn(Optional.of(getSchool()));

        SchoolInfoDto expectedSchoolDto = getSchoolInfoDto();
        SchoolInfoDto actualSchoolDto = schoolService.findById(ANY_LONG);

        assertEquals(expectedSchoolDto, actualSchoolDto);
    }

    @Test
    void should_ThrowResourceNotFoundException_When_RepositoryReturnNull() {
        when(mockedSchoolRepository.findById(ANY_LONG)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> schoolService.findById(ANY_LONG));
    }

    private SaveSchoolDto getSaveSchoolDto() {
        return SaveSchoolDto.builder()
                .address(ANY_STRING)
                .name(ANY_STRING)
                .region(ANY_STRING)
                .settlementName(ANY_STRING)
                .settlementType(SettlementType.CITY)
                .url(ANY_STRING)
                .build();
    }

    private SchoolInfoDto getSchoolInfoDto() {
        return SchoolInfoDto.builder()
                .address(ANY_STRING)
                .name(ANY_STRING)
                .region(ANY_STRING)
                .settlementName(ANY_STRING)
                .settlementType(SettlementType.CITY)
                .url(ANY_STRING)
                .build();
    }

    private School getSchool() {
        return School.builder()
                .address(ANY_STRING)
                .name(ANY_STRING)
                .region(ANY_STRING)
                .settlementName(ANY_STRING)
                .settlementType(SettlementType.CITY)
                .url(ANY_STRING)
                .build();
    }
}
