package org.telran.shop.de.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.converter.Converter;
import org.telran.shop.de.dto.DtoUser;
import org.telran.shop.de.dto.UserDto;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private Converter<User, DtoUser, UserDto> converter;

    @Autowired
    private PasswordEncoder encoder;


// GET -----------------------------------------------------------------------------------------------------------------

    @GetMapping("/login")
    public UserDto getByLogin(@RequestParam("login") String login) {
        User user = service.getByLogin(login);
        UserDto dto = converter.toDto(user);
        return dto;
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public UserDto create(@RequestBody @Valid DtoUser dto) {
        User user = converter.toEntity(dto);
        String password = user.getPassword();
        String encode = encoder.encode(password);
        user.setPassword(encode);
        User newUser = service.create(user);
        UserDto newDto = converter.toDto(newUser);
        return newDto;
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public User delete(@PathVariable long id) {
        return service.delete(id);
    }

// EXCEPTION -----------------------------------------------------------------------------------------------------------

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException exception) {
        Map<String, String> errorMap = new HashMap<>();
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : constraintViolations) {
            String message = violation.getMessage();
            String param = violation.getPropertyPath().toString();
            errorMap.put(param, message);
        }
        return errorMap;
    }

}
