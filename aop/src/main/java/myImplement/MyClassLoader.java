package myImplement;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private File baseDir;

    public MyClassLoader() {
        String baseDir = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new java.io.File(baseDir);
    }

    public Class findClass(String name) {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if(baseDir!=null){
            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            System.out.println("classFile: "+classFile);
            System.out.println(classFile.exists());
            if(classFile.exists()){
                FileInputStream in=null;
                ByteArrayOutputStream out=null;
                try{
                    in=new FileInputStream(classFile);
                    out=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int len;
                    while ((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                    classFile.delete();
                }
            }
        }
        return null;
    }
}