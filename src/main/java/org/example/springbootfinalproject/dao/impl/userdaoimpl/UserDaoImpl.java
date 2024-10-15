package org.example.springbootfinalproject.dao.impl.userdaoimpl;

import org.example.springbootfinalproject.dao.interfacedao.userdao.UserDao;
import org.example.springbootfinalproject.db.AbstractDao;
import org.example.springbootfinalproject.entity.user.User;
import org.hibernate.Hibernate;

public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
//    TODO findByEmail
//    @Override
//    public User findByEmail(String email) {
//        return findFirst(String.format("email = '%s'", email));
//    }


    @Override
    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getUserId());
        }

        return user;
    }
}
