package com.example.springboottest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class,properties = {"app.version=1.0"})
@SpringBootApplication
public class SpringbootTestApplicationTests {

    @Autowired
    ApplicationContext context;
    @Autowired
    Environment environment;
    @MockBean
    UserMapper userMapper;
    @Before
    public void before(){
        BDDMockito.given(userMapper.createUser("xiaoming")).willReturn(1);
        BDDMockito.given(userMapper.createUser("xiaohong")).willReturn(2);
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);
    }
	@Test(expected = NullPointerException.class)
	public void contextLoads() {
        Runnable bean = context.getBean(Runnable.class);
        Assert.assertEquals("1.0",environment.getProperty("app.version"));

        Assert.assertEquals(userMapper.createUser("xiaoming"),Integer.valueOf(1));
        Assert.assertEquals(userMapper.createUser("xiaohong"),Integer.valueOf(2));
        Assert.assertEquals(userMapper.createUser(null),Integer.valueOf(2));
    }

}
