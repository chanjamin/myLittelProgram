package com.My.Test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyClassPathXMLApplicationContext {
    public MyClassPathXMLApplicationContext(String filename) {
        this.readXML(filename);
        this.instanceBean();
        this.annotationInject();
    }

    /**
     * 保存需要实例化的bean
     */
    List<BeanDefine> beanList = new ArrayList<BeanDefine>();

    /**
     * 保存实例化后的bean
     */
    Map<String, Object> singleton = new ConcurrentHashMap<String, Object>();


    public void readXML(String filename){
        Document document=null;
        SAXReader saxReader=new SAXReader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            document=saxReader.read(contextClassLoader.getResourceAsStream(filename));
            Element rootElement = document.getRootElement();
         //collection特有for
            for(Iterator<Element> beansList=rootElement.elementIterator();beansList.hasNext();){
                Element element = beansList.next();
                BeanDefine beanDefine=new BeanDefine(element.attributeValue("id"),element.attributeValue("class"));
                beanList.add(beanDefine);
            }
        } catch (DocumentException e) {
            e.printStackTrace();

        }
    }

    public void instanceBean(){
        for (BeanDefine bd:beanList
             ) {
            try {
                singleton.put(bd.getId(),Class.forName(bd.getClassName()).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void annotationInject(){
        for (String beanName:singleton.keySet()
             ) {
            Object bean = singleton.get(beanName);
            if(bean!=null){
                this.propertyAnnotation(bean);
                this.fieldAnnotation(bean);
            }
        }
    }

    /**
     * 为bean中的property注入值
     *
     * @param bean
     */
    public void propertyAnnotation(Object bean) {
        try {
            //内省得到beaninfo,再得到properties
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor pd :
                    propertyDescriptors) {
                Method writeMethod = pd.getWriteMethod();
                if (writeMethod != null && writeMethod.isAnnotationPresent(MyResource.class)) {
                    MyResource annotation = writeMethod.getAnnotation(MyResource.class);
                    String name = "";
                    Object value = null;
                    //write方法上注解name属性有值
                    if (annotation.name() != null && !"".equals(annotation.name())) {
                        name = annotation.name();
                        value = singleton.get(name);
                        //无值
                    }
                    else {
                        for (String key : singleton.keySet()) {
                            //property类型是集合中一个元素的子类
                            if (pd.getPropertyType().isAssignableFrom(singleton.get(key).getClass())) {
                                value = singleton.get(key);
                                break;
                            }
                        }
                    }
                    writeMethod.setAccessible(true);
                    //调用bean的setter方法
                    writeMethod.invoke(bean, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fieldAnnotation(Object bean) {
        try {
            Field[] fields = bean.getClass().getFields();
            for (Field field :
                    fields) {
                if (field != null && field.isAnnotationPresent(MyResource.class)) {
                    MyResource annotation = field.getAnnotation(MyResource.class);
                    String name = "";
                    Object value = null;
                    if (annotation.name() != null && !annotation.name().equals("")) {
                        name = annotation.name();
                        value = singleton.get(name);
                        break;
                    }
                    else{
                        for (String key:singleton.keySet()
                             ) {
                            if(field.getType().isAssignableFrom(singleton.get(key).getClass())){
                                value=singleton.get(key);
                                break;
                            }
                        }
                    }
                    field.setAccessible(true);
                    field.set(bean, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanId){
        return singleton.get(beanId);
    }
}
