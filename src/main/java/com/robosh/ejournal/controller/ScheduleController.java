package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.schedule.SaveScheduleDto;
import com.robosh.ejournal.data.dto.schedule.ShowScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    @PostMapping
    public ShowScheduleDto saveSchedule(SaveScheduleDto saveScheduleDto) {
        return null;
    }

}
