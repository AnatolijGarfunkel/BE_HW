package org.telran.shop.de.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    // для создания объекта UserDto из User
    private long id;

    private String login;

    private String email;
}
