package com.example.springboottest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    public void test(){
        String rest = testRestTemplate.getForObject("/user/name", String.class);
        Assert.assertEquals("name",rest);
    }

    @Test
    public void test2(){
        String rest = testRestTemplate.getForObject("/user/return", String.class);
        Assert.assertEquals("name",rest);
    }

}