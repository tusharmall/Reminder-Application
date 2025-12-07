package com.example.reminderapp.mapper;

import com.example.reminderapp.dto.ReminderDto;
import com.example.reminderapp.model.Reminder;

public class ReminderMapper {

    public static ReminderDto toDto(Reminder r) {
        if (r == null) return null;

        return ReminderDto.builder()
                .id(r.getId())
                .title(r.getTitle())
                .description(r.getDescription())
                .remindAt(r.getRemindAt())
                .done(r.isDone())
                .build();
    }

    public static Reminder toEntity(ReminderDto dto) {
        if (dto == null) return null;

        return Reminder.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .remindAt(dto.getRemindAt())
                .done(dto.isDone())
                .build();
    }

    public static void update(Reminder r, ReminderDto dto) {
        r.setTitle(dto.getTitle());
        r.setDescription(dto.getDescription());
        r.setRemindAt(dto.getRemindAt());
        r.setDone(dto.isDone());
    }
}
