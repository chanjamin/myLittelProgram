import bean.ProxyHandler;
import bean.RealStar;
import bean.Star;
import dynamic_proxy_factory.AfterAdvice;
import dynamic_proxy_factory.BeforeAdvice;
import dynamic_proxy_factory.ProxyFactory;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Client {

    @Test
    public void test(){
        //参数2是代理类实现的接口
        Star proxyStar= (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},new ProxyHandler(new RealStar()));
        proxyStar.sing();
    }

    @Test
    public void TheTest(){
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Star.class});
        try {
            FileOutputStream os = new FileOutputStream("D:/$Proxy0.class");
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFactory(){
        Star star = (Star) new ProxyFactory(new BeforeAdvice(), new RealStar(), new AfterAdviceImpl()).createProxy();
        star.sing();
    }

    private static class BeforeAdvice implements dynamic_proxy_factory.BeforeAdvice{

        @Override
        public void before() {
            System.out.println("签合约");
        }
    }
    private static class AfterAdviceImpl implements AfterAdvice {

        @Override
        public void after() {
            System.out.println("收款");
        }
    }
}
