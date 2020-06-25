package com.robosh.ejournal.data.dto.schedule.item;

import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.data.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowScheduleItem {

    private Long id;

    private Subject subject;

    private TeacherDto teacherDto;

    private String cabinet;

    private DayOfWeek dayOfWeek;

    private Byte subjectNumber;
}
