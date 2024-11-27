package org.telran.shop.de.converter;

import org.telran.shop.de.dto.DtoUser;
import org.telran.shop.de.dto.UserDto;
import org.telran.shop.de.entity.User;

public class UserConverterImpl implements Converter<User, DtoUser, UserDto> {

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getEmail());
    }

    @Override
    public User toEntity(DtoUser dto) {
        return new User(dto.getLogin(), dto.getEmail());
    }
}
