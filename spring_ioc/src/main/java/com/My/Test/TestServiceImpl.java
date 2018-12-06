package com.My.Test;

public class TestServiceImpl {

	public TestObject3 TestObject3;
	public TestObject1 TestObject1;

	// 字段上的注解,可以配置name属性
	@MyResource
	public TestObject2 TestObject2;

	// set方法上的注解，带有name属性
	@MyResource(name = "TestObject3")
	public void setUserDao(TestObject3 TestObject3) {
		this.TestObject3 = TestObject3;
	}

	// set方法上的注解，没有配置name属性
	@MyResource
	public void setUser1Dao(TestObject1 TestObject1) {
		this.TestObject1 = TestObject1;
	}

	public void show() {
		
		TestObject1.show();
		TestObject2.show();
		TestObject3.show();
		
		System.out.println("调用了TestService方法........");
		
	}
}