package org.telran.shop.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


// GET -----------------------------------------------------------------------------------------------------------------

    @GetMapping
    public List<User> getAll () {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping("/login")
    public User getByName (@RequestParam String login) {
        return userService.getByName(login);
    }

    @GetMapping("/fulladress")
    public List<User> getByFullAddress(@RequestParam String fullAddress) {
        return userService.getByFullAdress(fullAddress);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @PutMapping("/adress/{id}")
    public User updateAdress(@PathVariable long id, @RequestBody User user) {
        return userService.updateAdress(id, user);
    }


    @PostMapping("/equals_password")
    public List<User> getWithEqualsPassword(@RequestBody String password) {
        return userService.getWithEqualsPassword(password);
    };

// DELETE --------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public User delete(@PathVariable long id) {
        return userService.delete(id);
    }

}
