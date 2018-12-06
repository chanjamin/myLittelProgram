import bean.SampleBean;
import bean.SampleClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.beans.ImmutableBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

public class TestIt {

    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((FixedValue) () -> "1234");
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(proxy.hashCode());
    }

    @Test(expected = IllegalStateException.class)
    public void testImmutableBean() throws Exception{
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //创建不可变类
        Assert.assertEquals("Hello world",immutableBean.getValue());
        bean.setValue("Hello world, again"); //可以通过底层对象来进行修改
        Assert.assertEquals("Hello world, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); //直接修改将throw exception
    }
}
