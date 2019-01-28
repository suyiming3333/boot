package com.sym.myboot.mapper.slave;

import com.sym.myboot.entity.User;

import java.util.List;

/**
 * @ClassName: MasterUserMapper
 * @Auther: Suyiming3333
 * @Date: 2019/1/28 0028 15:20
 * @Description:
 * @Version:
 */
public interface SlaveUserMapper {
    List<User> selectAll();
}
