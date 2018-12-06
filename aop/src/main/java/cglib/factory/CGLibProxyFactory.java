package cglib.factory;

import cglib.dao.UserDao;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxyFactory {
    private Object target;

    public CGLibProxyFactory(Object target) {
        this.target = target;
    }

    private Callback callback=new MethodInterceptor() {
        /**
         *
         * @param o   代理对象
         * @param method    当期调用方法
         * @param objects  方法参数
         * @param methodProxy 被调用方法的代理对象(用于执行父类的方法)
         * @return
         * @throws Throwable
         */
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            // 前置增强
            System.out.println("+ Before Advice ...");

            // 执行目标方法
            //Object result = method.invoke(target, args);
            Object result = methodProxy.invoke(target, objects);

            // 后置增强
            System.out.println("+ After Advice ...");

            return result;
        }
    };

    public Object createProxy(){
        // 1. 创建Enhancer对象
        Enhancer enhancer = new Enhancer();



        // 2. cglib创建代理, 对目标对象创建子对象
        enhancer.setSuperclass(target.getClass());

        // 3. 传入回调接口, 对目标增强
        enhancer.setCallback(callback);

        return enhancer.create();
    }

    public static void main(String[] args) {
        UserDao proxy = (UserDao) new CGLibProxyFactory(new UserDao()).createProxy();
        proxy.add("123");
        proxy.get("456");
    }
}
