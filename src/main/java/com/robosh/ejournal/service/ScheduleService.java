package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.schedule.SaveScheduleDto;
import com.robosh.ejournal.data.entity.Schedule;
import com.robosh.ejournal.data.mapping.ScheduleMapper;
import com.robosh.ejournal.data.repository.ScheduleRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;


    public SaveScheduleDto findAllByGroupId(Long groupId) {
        Schedule schedule = scheduleRepository.findAllByGroupId(groupId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Schedule", "groupId", groupId)
                );
        return scheduleMapper.fromScheduleToSaveScheduleDto(schedule);
    }

    public SaveScheduleDto findAllByTeacherId(Long teacherId) {
        Schedule schedule = scheduleRepository.findAllByTeacherId(teacherId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Schedule", "teacherId", teacherId)
                );
        return scheduleMapper.fromScheduleToSaveScheduleDto(schedule);
    }

    public SaveScheduleDto saveSchedule(SaveScheduleDto saveScheduleDto) {
        Schedule toSave = scheduleMapper.fromSaveScheduleDtoToSchedule(saveScheduleDto);
        Schedule afterSave = scheduleRepository.save(toSave);
        return scheduleMapper.fromScheduleToSaveScheduleDto(afterSave);
    }

    public SaveScheduleDto updateSchedule(SaveScheduleDto saveScheduleDto) {
        Schedule toUpdate = scheduleMapper.fromSaveScheduleDtoToSchedule(saveScheduleDto);
        Schedule current = findById(toUpdate.getId());
        return scheduleMapper.fromScheduleToSaveScheduleDto(current);
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Schedule", "id", id)
                );
    }
}
