package com.lyceum.habitapi.controllers;

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

    private final HabitService habitService;

    @PostMapping()
    public ResponseEntity addHabit(@RequestBody Habit habit, @RequestParam String idUser) {
        habitService.addHabit(habit, idUser);
        return ResponseEntity.ok().build();

    }
}
