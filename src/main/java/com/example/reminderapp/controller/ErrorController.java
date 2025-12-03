package com.example.reminderapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/customerror")  // This is causing the conflict
    public String handleError() {
        // Your custom error handling logic here
        return "error"; // The view name to display
    }
}
