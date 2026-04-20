package com.demo.first.app.service;

import com.demo.first.app.controller.UserController;
import com.demo.first.app.exceptions.UserNotFoundException;
import com.demo.first.app.model.User;
import com.demo.first.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService
{
    private final UserRepository userRepository;
    private final Logger logger= LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        System.out.println("Saving user...");
        return userRepository.save(user);
    }

    public User updateUser(User user)
    {
        User exixting = userRepository.findById(user.getId()).
        orElseThrow(
                ()->new UserNotFoundException("User with ID "+user.getId()+"dose not exist")
        );

        exixting.setName(user.getName());
        exixting.setEmail(user.getEmail());
        return userRepository.save(exixting);

    }


    public boolean deleteUser(int id)
        {
            if (!userRepository.existsById(id))
                throw new UserNotFoundException("User with ID " + id + "dose not exist");
            userRepository.deleteById(id);
              return true;
    }

public List<User> getAllUsers()
{
    List<User> user=userRepository.findAll();
    if (user.isEmpty())
        throw new NullPointerException("No users found in the database");
    return  user;
}

    public  User getUserByID(int id)
    {
        return userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("uSER WITH ID"+id+"dose not existes")
        );
    }




    public List<User> searchUsers(String name, String email) {

     return  userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);
   //  return  userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);
    }
}
