// the code is written by tushar.mall
// the code is written by tushar.mall
// the code is written by tushar.mall
package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ReminderService {

    List<Reminder> getAllReminders();

    Page<Reminder> getAllReminders(Pageable pageable);

    Optional<Reminder> getReminder(Long id);

    Reminder saveReminder(Reminder reminder);

    Reminder updateReminder(Long id, Reminder reminder);

    void deleteReminder(Long id);

    /**
     * Simple in-memory search/filter.
     * If dayOfWeek is null it is ignored. If beforeTime is null it is ignored.
     */
    List<Reminder> search(String dayOfWeek, LocalTime beforeTime);
}