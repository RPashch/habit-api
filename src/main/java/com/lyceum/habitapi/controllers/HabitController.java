package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.service.HabitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/habit")
public class HabitController {

    @Autowired
    private final HabitService habitService;

    @PostMapping()
    public ResponseEntity<Object> addHabit(@RequestBody Habit habit, @RequestParam String user_id) {
        habitService.addHabit(habit, user_id);
        return ResponseEntity.ok().build();

    }
}
