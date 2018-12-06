import bean.ProxyHandler;
import bean.RealStar;
import bean.Star;
import myImplement.MyClassLoader;
import myImplement.MyInvocationHandler;
import myImplement.MyProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMyImp {
    @Test
    public void test(){
        Star star=new RealStar();

        Star proxiedStar= (Star) MyProxy.newProxyInstance(new MyClassLoader(),star.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("before invoke");
            Object result=null;
            result=method.invoke(star,args);
            System.out.println("after invoke");
            return result;
        });

        proxiedStar.sing();
    }


}
