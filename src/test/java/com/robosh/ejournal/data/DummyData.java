package com.robosh.ejournal.data;

import com.robosh.ejournal.data.dto.group.GroupDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.Group;
import com.robosh.ejournal.data.entity.School;

import java.time.LocalDate;

public interface DummyData {
    String EMPTY_STRING = "";
    Long ANY_LONG = 1L;
    String CORRECT_EMAIL = "email@email.com";
    String INCORRECT_EMAIL = "incorrect";
    String NAME = "Name";
    String PASSWORD = "password";
    String ANY_STRING = "string";
    String VALID_PHONE = "380961248850";
    LocalDate ANY_DATE = LocalDate.of(2000, 3, 12);
    School ANY_SCHOOL = School.builder()
            .id(ANY_LONG)
            .build();
    SchoolInfoDto ANY_SCHOOL_DTO = SchoolInfoDto.builder().id(ANY_LONG).build();
    Group ANY_GROUP = Group.builder().id(ANY_LONG).build();
    GroupDto ANY_GROUP_DTO = GroupDto.builder().id(ANY_LONG).build();
}
