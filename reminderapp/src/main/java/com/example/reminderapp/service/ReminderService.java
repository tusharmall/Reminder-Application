//package com.example.reminderapp.service;
//
//import com.example.reminderapp.model.Reminder;
//import com.example.reminderapp.repository.ReminderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ReminderService {
//
//    @Autowired
//    private ReminderRepository reminderRepository;
//
//    // Method to get all reminders
//
//    public List<Reminder> getAllReminders() {
//        return reminderRepository.findAll();
//    }
//
//    // Method to save a reminder
//    public void saveReminder(Reminder reminder) {
//        reminderRepository.save(reminder);
//    }
//}
package com.example.reminderapp.service;

import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    // Method to get all reminders
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    // Method to save a reminder
    public void saveReminder(Reminder reminder) {
        reminderRepository.save(reminder);
    }
}
