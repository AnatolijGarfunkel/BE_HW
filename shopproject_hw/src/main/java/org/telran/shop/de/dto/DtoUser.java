package org.telran.shop.de.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DtoUser {

    // для создания объекта User из UserDto

    private String login;

    private String email;

}
