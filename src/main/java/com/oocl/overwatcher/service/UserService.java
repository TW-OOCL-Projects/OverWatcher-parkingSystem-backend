package com.oocl.overwatcher.service;

import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository=repository;
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User findUserByParkingBoy(Long id){
        return userRepository.findById(id).get();
    }
    public boolean  addUser(User user){
        User saveUser = userRepository.save(user);
        return saveUser!=null;
    }
    public boolean updateStatus(User user) {
        int updateNum = userRepository.updateStatusById(user.getId(),user.getStatus());
        return updateNum!=0;
    }
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public boolean updateBasicMessageOfEmployees(User user){
        int updateNum = userRepository.updateBasicMessageOfEmployees(user.getId(),user.getName(),user.getStatus(),user.getEmail(),user.getPhone());
        return updateNum!=0;
    }


}