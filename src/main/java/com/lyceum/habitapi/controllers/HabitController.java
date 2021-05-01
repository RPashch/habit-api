package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.HabitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/habit")
public class HabitController {

    @Autowired
    private final HabitService habitService;

    @GetMapping("/all/userId")
    public HttpEntity<ArrayList<Habit>> getUserHabits(long userId) {
        ArrayList<Habit> userHabits = habitService.getUserHabits(userId);

        return ResponseEntity.ok(userHabits);
    }

}
