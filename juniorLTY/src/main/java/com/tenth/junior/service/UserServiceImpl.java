package com.tenth.junior.service;

import com.tenth.junior.bean.User;
import com.tenth.junior.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String user_name){
        return userRepository.getUserByName(user_name);
    }

    @Override
    public long getUserNum(){
        return 1 + userRepository.getUserNumber();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByID(Integer userid){
        return userRepository.findById(userid);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public  void deleteUser(User user){
        userRepository.deleteById(user.getUserID());
    }
}


