package com.robosh.ejournal.data.dto.schedule;

import com.robosh.ejournal.data.dto.group.GroupDto;
import com.robosh.ejournal.data.dto.schedule.item.SaveScheduleItemDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShowScheduleDto {

    private Long id;

    private GroupDto groupDto;

    private List<SaveScheduleItemDto> scheduleList;
}
