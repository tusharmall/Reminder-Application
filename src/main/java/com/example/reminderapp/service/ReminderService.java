package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;

import java.util.List;
import java.util.Optional;

public interface ReminderService {
    Reminder create(Reminder reminder);
    Reminder update(Long id, Reminder reminder);
    Optional<Reminder> getById(Long id);
    List<Reminder> getAll();
    void delete(Long id);
    List<Reminder> findDue();
}
