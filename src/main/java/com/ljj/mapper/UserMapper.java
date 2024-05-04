package com.ljj.mapper;

import java.util.List;
import com.ljj.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    List<User>listUser();

    User phonegetUser(long phone);

    int updateUser(User user);

    int addUser(User user);
}
