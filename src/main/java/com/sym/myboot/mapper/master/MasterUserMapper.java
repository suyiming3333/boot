package com.sym.myboot.mapper.master;

import com.sym.myboot.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @ClassName: MasterUserMapper
 * @Auther: Suyiming3333
 * @Date: 2019/1/28 0028 15:20
 * @Description:
 * @Version:
 */
public interface MasterUserMapper {
    List<User> selectAll();

    User getUserById(Integer id);

    void updateUserById(User user);
}
