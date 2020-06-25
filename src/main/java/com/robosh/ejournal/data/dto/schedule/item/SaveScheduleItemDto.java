package com.robosh.ejournal.data.dto.schedule.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveScheduleItemDto {

    private Long id;

    private Long subjectId;

    private Long teacherId;

    private String cabinet;

    private DayOfWeek dayOfWeek;

    private Byte subjectNumber;

}
