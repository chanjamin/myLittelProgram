package me.imjamin.service;

import me.imjamin.UserService;
import me.imjamin.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0", timeout = 10000, retries = 0)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public String[] selectName() {
        return userMapper.selectName();
    }
}
