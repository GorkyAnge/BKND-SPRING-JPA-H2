package com.gorkyange.apirest.apirest;

import com.gorkyange.apirest.apirest.config.DBCacheConfig;
import com.gorkyange.apirest.apirest.model.User;
import com.gorkyange.apirest.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Cacheable(value = DBCacheConfig.USERS_CACHE)
    public List<User> getUsers() {
        simulateSlowService();
        return userRepository.findAll();
    }


    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
