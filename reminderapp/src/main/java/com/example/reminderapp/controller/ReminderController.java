//
//package com.example.reminderapp.controller;
//
//import com.example.reminderapp.model.Reminder;
//import org.springframework.validation.BindingResult;
//import jakarta.validation.Valid;
//
//import com.example.reminderapp.service.ReminderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.time.LocalTime;
//import java.util.List;
//
//@Controller
//public class ReminderController {
//
//    @Autowired
//    private ReminderService reminderService;
//
//    // GET request to show reminders
//    @GetMapping("/rem")
//    public String showReminders(Model model) {
//        List<Reminder> reminders = reminderService.getAllReminders();
//        if (reminders.isEmpty()) {
//            System.out.println("No reminders found");
//        } else {
//            System.out.println("Reminders found: " + reminders);
//        }
//        model.addAttribute("reminders", reminders);
//        return "reminder";
//    }
//
//
//    // POST request to save a new reminder
//
//    @PostMapping("/saveReminder")
//    public String saveReminder(@Valid @ModelAttribute("reminder") Reminder reminder, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            List<Reminder> reminders = reminderService.getAllReminders();
//            model.addAttribute("reminders", reminders);  // Re-display all reminders
//            return "reminder";  // Return the same JSP that displays the form
//        }
//
//        // Save the valid reminder
//        reminderService.saveReminder(reminder);
//        return "redirect:/rem";  // Redirect to display all reminders after saving
//    }
//
//   
//
//
//}


package com.example.reminderapp.controller;

import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    // GET request to show reminders
    @GetMapping("/rem")
    public String showReminders(Model model) {
        List<Reminder> reminders = reminderService.getAllReminders(); // Ensure this returns the expected data
        model.addAttribute("reminders", reminders); // Check if the attribute name matches what you are using in JSP
        return "reminder"; // This should correspond to reminder.jsp
    }


    // POST request to save a new reminder
    @PostMapping("/saveReminder")
    public String saveReminder(@Valid @ModelAttribute("reminder") Reminder reminder, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Handle errors
            List<Reminder> reminders = reminderService.getAllReminders();
            model.addAttribute("reminders", reminders);
            return "reminder";  // Return to the same JSP if there are validation errors
        }

        // Save the valid reminder
        reminderService.saveReminder(reminder);
        return "redirect:/rem";  // Redirect to show reminders after saving
    }
}
