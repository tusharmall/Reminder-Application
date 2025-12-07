package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository repo;

    public ReminderServiceImpl(ReminderRepository repo) {
        this.repo = repo;
    }

    @Override
    public Reminder create(Reminder reminder) {
        return repo.save(reminder);
    }

    @Override
    public Reminder update(Long id, Reminder reminder) {
        return repo.findById(id).map(r -> {
            r.setTitle(reminder.getTitle());
            r.setDescription(reminder.getDescription());
            r.setRemindAt(reminder.getRemindAt());
            r.setDone(reminder.isDone());
            return repo.save(r);
        }).orElseThrow(() -> new RuntimeException("Reminder not found"));
    }

    @Override
    public Optional<Reminder> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Reminder> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Reminder> findDue() {
        return repo.findByDoneFalseAndRemindAtBefore(LocalDateTime.now());
    }
}
