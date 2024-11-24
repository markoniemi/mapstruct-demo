package org.example.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserMapperImpl.class)
public class UserMapperTest {
  @Autowired UserMapper mapper;
  User user = new User("username", "password", "email", Role.ROLE_ADMIN);

  @Test
  public void mapUser() {
    org.example.api.user.User mappedUser = mapper.map(user);

    assertEquals("username", mappedUser.getUsername());
    assertEquals(Role.ROLE_ADMIN.name(), mappedUser.getRole().name());
  }

  @Test
  public void mapUsers() {
    List<org.example.api.user.User> mappedUsers = mapper.mapUsers(Arrays.asList(user));
    org.example.api.user.User mappedUser = mappedUsers.get(0);
    assertEquals("username", mappedUser.getUsername());
    assertEquals(Role.ROLE_ADMIN.name(), mappedUser.getRole().name());
  }

  @Test
  public void testDepedencyInjection() {
    assertNotNull(mapper);
    assertNotNull(mapper.applicationContext);
  }
}
