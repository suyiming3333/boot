package com.sym.myboot.service;

import com.sym.myboot.dao.UserDao;
import com.sym.myboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    public void createUser(String id,String name, Integer age) {
        System.out.println("createUser");
        jdbcTemplate.update("insert into sys_user(id,name,age) values(?,?,?);",id, name, age);
        System.out.println("创建用户成功...");
    }

    public User getUserById(Integer id) {
        User user = userDao.findOne(id);
        return user;
    }

    public void saveUser() {
        User user = new User();
        user.setId("10087");
        user.setName("asudasd");
        userDao.save(user);

    }

}

