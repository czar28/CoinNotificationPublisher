package org.example.dao;

import org.example.model.User;

public interface UserDAO {

    public void saveUser(User user);
    public void updateUser(User user);
    public User getUserById(Integer userId);
}
