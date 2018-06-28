package com.tenth.junior.service;
import com.tenth.junior.bean.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    User addUser(User user);

    Optional<User> getUserByID(Integer id);

    User updateUser(User user);

    void deleteUser(User user);

    public long getUserNum();

}
