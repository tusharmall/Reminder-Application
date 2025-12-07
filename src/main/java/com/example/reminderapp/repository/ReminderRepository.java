package com.example.reminderapp.repository;

import com.example.reminderapp.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    // This method MUST exist to fix your error
    List<Reminder> findByDoneFalseAndRemindAtBefore(LocalDateTime time);
}
