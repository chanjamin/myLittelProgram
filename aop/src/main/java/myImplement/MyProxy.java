package myImplement;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
   public static final  String ln="\r\n";

    public static  Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler handler) {
        try {
            //生成源码
            String proxy = generateSrc(interfaces[0]);
            //写到硬盘
            String path = MyProxy.class.getResource("").getPath();
            File file = new File(path, "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            System.out.println(file.getAbsolutePath());
            fileWriter.write(proxy);
            fileWriter.flush();
            fileWriter.close();
            //编译源代码，并且生成.class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
            task.call();
            standardFileManager.close();
//            返回被代理后的对象
            Class proxyClass=loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
//            file.delete();
            return constructor.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package myImplement;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{ "+ ln);
        src.append("MyInvocationHandler h;" + ln);
        src.append("public $Proxy0(MyInvocationHandler h){" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" +ln);
        for(Method m : interfaces.getMethods()){
            src.append("public "+m.getReturnType().getName()+ " "+m.getName()+"()"+"{"+ln);
            src.append("try{"+ln);
            src.append("Method m = " + interfaces.getName()+".class.getMethod(\"" + m.getName() + "\",new Class[]{});"+ln);
            src.append("this.h.invoke(this,m,null);" + ln);

            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);

            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }
}
