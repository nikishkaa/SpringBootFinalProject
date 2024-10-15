package org.example.springbootfinalproject.service;

import org.example.springbootfinalproject.dao.interfacedao.userdao.UserDao;
import org.example.springbootfinalproject.entity.user.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
