package com.lyceum.habitapi.controllers;


import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/{name}")
    public HttpEntity<Iterable<User>> getByUserName(@PathVariable("name") String name) {
        Iterable<User> usersByUserName = userRepository.findByUserName(name);

        return ResponseEntity.ok(usersByUserName);
    }

    @PostMapping()
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUserData(@RequestBody User user, @PathVariable("id") long id) {

        userService.updateUserData(user, id);
        return ResponseEntity.ok().build();
    }

}
