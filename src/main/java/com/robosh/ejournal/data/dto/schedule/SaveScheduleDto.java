package com.robosh.ejournal.data.dto.schedule;

import com.robosh.ejournal.data.dto.schedule.item.SaveScheduleItemDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SaveScheduleDto {

    private Long id;

    private Long groupId;

    private List<SaveScheduleItemDto> scheduleList;

}
