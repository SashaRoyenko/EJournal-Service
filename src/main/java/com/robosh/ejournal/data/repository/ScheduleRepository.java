package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findAllByGroupId(Long groupId);

    @Query(value = "SELECT * FROM schedule" +
            " JOIN schedule_schedule_item" +
            " ON schedule.id = schedule_id" +
            " JOIN schedule_item" +
            " ON schedule_item.id = schedule_item_id" +
            " WHERE teacher_id = :teacherId", nativeQuery = true)
    Optional<Schedule> findAllByTeacherId(Long teacherId);
}
