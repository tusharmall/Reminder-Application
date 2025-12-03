package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Override
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    @Override
    public Page<Reminder> getAllReminders(Pageable pageable) {
        return reminderRepository.findAll(pageable);
    }

    @Override
    public Optional<Reminder> getReminder(Long id) {
        return reminderRepository.findById(id);
    }

    @Override
    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public Reminder updateReminder(Long id, Reminder reminder) {
        return reminderRepository.findById(id).map(existing -> {
            existing.setDayOfWeek(reminder.getDayOfWeek());
            existing.setTime(reminder.getTime());
            existing.setActivity(reminder.getActivity());
            return reminderRepository.save(existing);
        }).orElseGet(() -> {
            // If not found, treat as create with provided id removed
            reminder.setId(null);
            return reminderRepository.save(reminder);
        });
    }

    @Override
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public List<Reminder> search(String dayOfWeek, LocalTime beforeTime) {
        List<Reminder> all = reminderRepository.findAll();
        return all.stream()
                .filter(r -> dayOfWeek == null || dayOfWeek.isBlank() || dayOfWeek.equalsIgnoreCase(r.getDayOfWeek()))
                .filter(r -> beforeTime == null || (r.getTime() != null && r.getTime().isBefore(beforeTime)))
                .collect(Collectors.toList());
    }
}