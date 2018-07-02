package com.tenth.junior.service;
import com.tenth.junior.bean.User;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    User addUser(User user);

    Optional<User> findByID(Integer userid);

    User updateUser(User user);

    void deleteUser(User user);

    User findByName(String user_name);

    public long getUserNum();
}
