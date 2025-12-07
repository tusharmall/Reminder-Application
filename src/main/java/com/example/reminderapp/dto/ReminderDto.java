package com.example.reminderapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderDto {

    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    private String description;

    @NotNull(message = "remindAt is required")
    private LocalDateTime remindAt;

    private boolean done;
}
