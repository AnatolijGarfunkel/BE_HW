package org.telran.shop.de.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DtoUser {

    // для создания объекта User из UserDto

    @NotBlank
    @NotEmpty
    private String login;

    @Email
    private String email;

    @NotEmpty
    @NotEmpty
    private String password;

}
