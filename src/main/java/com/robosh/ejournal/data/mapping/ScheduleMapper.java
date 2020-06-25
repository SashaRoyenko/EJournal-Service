package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.schedule.SaveScheduleDto;
import com.robosh.ejournal.data.dto.schedule.ShowScheduleDto;
import com.robosh.ejournal.data.dto.schedule.item.SaveScheduleItemDto;
import com.robosh.ejournal.data.entity.Schedule;
import com.robosh.ejournal.data.entity.ScheduleItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface ScheduleMapper {

    @Mapping(source = "groupId", target = "group.id")
    Schedule fromSaveScheduleDtoToSchedule(SaveScheduleDto saveScheduleDto);

    @InheritInverseConfiguration
    SaveScheduleDto fromScheduleToSaveScheduleDto(Schedule schedule);

    Schedule fromShowScheduleDtoToSchedule(ShowScheduleDto showScheduleDto);

    ShowScheduleDto fromScheduleToShowScheduleDto(Schedule schedule);

    @Mappings(
            value = {
                    @Mapping(source = "subjectId", target = "subject.id"),
                    @Mapping(source = "teacherId", target = "teacher.id")
            }
    )
    ScheduleItem fromSaveScheduleItemDtoToScheduleItem(SaveScheduleItemDto saveScheduleItemDto);

    @InheritInverseConfiguration
    SaveScheduleItemDto fromScheduleItemToSaveScheduleItemDto(ScheduleItem scheduleItem);


    ScheduleItem fromShowScheduleItemDtoToScheduleItem(ShowScheduleDto showScheduleDto);

    ShowScheduleDto fromScheduleItemToShowScheduleItemDto(ScheduleItem scheduleItem);
}
