
package com.example.reminderapp.model;

import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Day of the week is required")
    private String dayOfWeek;

    @NotNull(message = "Time is required")
    private LocalTime time;

    @NotBlank(message = "Activity is required")
    private String activity;

    public Reminder() {
    }

    public Reminder(Long id, @NotBlank(message = "Day of the week is required") String dayOfWeek,
                    @NotNull(message = "Time is required") LocalTime time,
                    @NotBlank(message = "Activity is required") String activity) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.activity = activity;
    }

    // Getters and setters omitted for brevity
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Reminder [id=" + id + ", dayOfWeek=" + dayOfWeek + ", time=" + time + ", activity=" + activity + "]";
    }
}
