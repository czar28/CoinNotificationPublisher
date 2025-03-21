package org.example.dao.impl;

import org.example.dao.UserDAO;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAOImpl implements UserDAO {

    Map<Integer, User> userMap;

    public UserDAOImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUserById(Integer userId) {

        if(!userMap.containsKey(userId)) {
            System.out.println("No user exists");
        }
        return userMap.get(userId);
    }
}
