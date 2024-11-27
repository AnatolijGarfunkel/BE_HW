package org.telran.shop.de.converter;

public interface Converter <Entity, DtoUser, UserDto> {

    UserDto toDto(Entity entity);

    Entity toEntity(DtoUser dto);
}
