package org.telran.shop.de.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.converter.Converter;
import org.telran.shop.de.dto.DtoUser;
import org.telran.shop.de.dto.UserDto;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.exception.AllreadyExist;
import org.telran.shop.de.exception.NotFoundException;
import org.telran.shop.de.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private Converter<User, DtoUser, UserDto> converter;


// GET -----------------------------------------------------------------------------------------------------------------

    @GetMapping("/login")
    public UserDto getByLogin(@RequestParam("login") String login) {
        User user = service.getByLogin(login);
        UserDto dto = converter.toDto(user);
        return dto;
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public User create(@RequestBody DtoUser dto) {
        User user = converter.toEntity(dto);
        return service.create(user);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public User delete(@PathVariable long id) {
        return service.delete(id);
    }

// EXCEPTION -----------------------------------------------------------------------------------------------------------

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(AllreadyExist.class)
    public String handleAllreadyExistException(Exception exception) {
        return exception.getMessage();
    }
}
