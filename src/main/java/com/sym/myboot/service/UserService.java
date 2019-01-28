package com.sym.myboot.service;

import com.sym.myboot.dao.UserDao;
import com.sym.myboot.entity.User;
import com.sym.myboot.mapper.UserMapper;
import com.sym.myboot.mapper.master.MasterUserMapper;
import com.sym.myboot.mapper.slave.SlaveUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private MasterUserMapper masterUserMapper;

    @Autowired
    private SlaveUserMapper slaveUserMapper;

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

    public List<User> selectAll1(){
        List<User> list = masterUserMapper.selectAll();
        return list;
    }

    public List<User> selectAll2(){
        List<User> list = slaveUserMapper.selectAll();
        return list;
    }

}

