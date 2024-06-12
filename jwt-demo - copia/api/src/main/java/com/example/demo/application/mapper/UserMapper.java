package com.example.demo.application.mapper;

import com.example.demo.application.dto.UserDto;
import com.example.demo.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        uses = { BookRegisterMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper extends EntityMapper<UserDto, User> {

    default User fromId(String username) {
        if (username == null) {
            return null;
        }
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
