package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.dao.HabitRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
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
    private final UserRepository userRepository;

    @GetMapping("/habits")
    public HttpEntity<ArrayList<Habit>> getUserHabits(User user) {
        ArrayList<Habit> userHabits = userRepository.getUserHabits(user.getId());

        return ResponseEntity.ok(userHabits);
    }

}
