package com.example.reminderapp.controller;

import com.example.reminderapp.dto.ReminderDto;
import com.example.reminderapp.mapper.ReminderMapper;
import com.example.reminderapp.model.Reminder;
import com.example.reminderapp.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reminders")
public class ReminderRestController {

    private final ReminderService service;

    public ReminderRestController(ReminderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReminderDto> create(@Valid @RequestBody ReminderDto dto) {
        Reminder saved = service.create(ReminderMapper.toEntity(dto));
        return ResponseEntity.created(URI.create("/api/reminders/" + saved.getId()))
                .body(ReminderMapper.toDto(saved));
    }

    @GetMapping
    public List<ReminderDto> getAll() {
        return service.getAll().stream().map(ReminderMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReminderDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(r -> ResponseEntity.ok(ReminderMapper.toDto(r)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReminderDto> update(@PathVariable Long id, @Valid @RequestBody ReminderDto dto) {
        try {
            Reminder updated = service.update(id, ReminderMapper.toEntity(dto));
            return ResponseEntity.ok(ReminderMapper.toDto(updated));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/due")
    public List<ReminderDto> dueReminders() {
        return service.findDue().stream().map(ReminderMapper::toDto).collect(Collectors.toList());
    }
}
