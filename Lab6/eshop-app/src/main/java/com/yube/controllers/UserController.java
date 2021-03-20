package com.yube.controllers;

import com.yube.model.dto.User;
import com.yube.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @GetMapping("/email-and-password")
    public User findByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.findByEmailAndPassword(email, password);
    }

    @PostMapping("")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
}
