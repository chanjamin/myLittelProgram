package com.example.springboottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)k
public class MockMvcTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testMvc() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/user/name")).andExpect(MockMvcResultMatchers.content().string("name"));
        mvc.perform(MockMvcRequestBuilders.get("/user/return").param("name","xioaming")).andExpect(MockMvcResultMatchers.content().string("xioaming"));

    }
}
