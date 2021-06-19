package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.HabitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/habit")
public class HabitController {

    @Autowired
    private final HabitService habitService;

    @Autowired
    private final HabitRepository habitRepository;

    @GetMapping("/{habitId}")
    public HttpEntity<Iterable<Habit>> findByHabitId(@PathVariable("habitId") long habitId) {
        Iterable<Habit> habitsById = habitRepository.findByHabitId(habitId);

        return ResponseEntity.ok(habitsById);
    }

//    @GetMapping("/CategoryId/{CatId}")
//    public HttpEntity<Iterable<Habit>> findByCategoryId(@PathVariable("CatId") long CatId) {
//        Iterable<Habit> habitsByCatId = habitRepository.findByCategoryId(CatId);
//
//        return ResponseEntity.ok(habitsByCatId);
//    }

    @PostMapping()
    public ResponseEntity addHabit(@RequestBody Habit habit, @RequestParam String idUser) {
        habitService.addHabit(habit, idUser);
        return ResponseEntity.ok().build();

    }
}
