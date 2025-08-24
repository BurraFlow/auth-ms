package co.com.authentication.api.mapper;

import co.com.authentication.api.dto.CreateUserDto;
import co.com.authentication.api.dto.UpdateUserDto;
import co.com.authentication.api.dto.UserDto;
import co.com.authentication.model.user.User;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserDtoMapper {

  UserDto toResponse(User user);

  List<UserDto> toResponseList(List<User> users);

  User toModel(CreateUserDto createUserDTO);

  User toModel(UpdateUserDto editUserDTO);

}

