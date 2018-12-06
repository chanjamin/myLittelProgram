package com;

import com.My.Test.MyClassPathXMLApplicationContext;
import com.My.Test.TestServiceImpl;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        MyClassPathXMLApplicationContext path = new MyClassPathXMLApplicationContext("test.xml");
        TestServiceImpl userService = (TestServiceImpl) path.getBean("TestService");
        userService.show();
    }

}
