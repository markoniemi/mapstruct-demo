package org.example.model.user;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
  // only to test that beans are injected to mapper
  @Autowired
  ApplicationContext applicationContext;
  @Mapping(source = "role", target = "role")
  abstract org.example.api.user.User map(User user);

  abstract List<org.example.api.user.User> mapUsers(List<User> users);

  abstract User map(org.example.api.user.User user);

  @AfterMapping
  public org.example.api.user.User mapUser(User source, @MappingTarget org.example.api.user.User target) {
    return target;
  }
}
