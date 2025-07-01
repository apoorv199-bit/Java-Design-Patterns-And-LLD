package org.library.LLD.FitnessClassBookingSystem.services;

import org.library.LLD.FitnessClassBookingSystem.enums.UserTier;
import org.library.LLD.FitnessClassBookingSystem.exceptions.UserNotFoundException;
import org.library.LLD.FitnessClassBookingSystem.models.User;
import org.library.LLD.FitnessClassBookingSystem.utils.IDGenerator;
import org.library.LLD.FitnessClassBookingSystem.utils.ValidationUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private Map<String, User> users;
    private Map<String, String> emailToUserId;

    public UserService(){
        this.users = new ConcurrentHashMap<>();
        this.emailToUserId = new ConcurrentHashMap<>();
    }

    public boolean registerUser(String name, String email, String password, UserTier tier){
        if(!ValidationUtils.isValidName(name)){
            throw new IllegalArgumentException("Invalid name");
        }
        if(!ValidationUtils.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid email");
        }
        if(!ValidationUtils.isValidPassword(password)){
            throw new IllegalArgumentException("Invalid password");
        }

        if(emailToUserId.containsKey(email)){
            return false;
        }

        String userId = IDGenerator.generateUserId();
        User user = new User(userId, name, email, password, tier);
        users.put(userId, user);
        emailToUserId.put(email, userId);
        return true;
    }

    public User login(String email, String password){
        String userId = emailToUserId.get(email);
        if(userId != null){
            User user = users.get(userId);
            if(user != null && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public User getUserById(String userId){
        User user = users.get(userId);
        if(user == null){
            throw new UserNotFoundException("User not found with Id: " + userId);
        }
        return user;
    }

    public boolean upgradeUserTier(String userId, UserTier tier){
        User user = users.get(userId);
        if(user != null){
            user.setTier(tier);
            return true;
        }
        return false;
    }

    public boolean userExist(String userId){
        return users.containsKey(userId);
    }
}
