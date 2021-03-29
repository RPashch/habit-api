package com.lyceum.habitapi.controllers;


import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
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

}