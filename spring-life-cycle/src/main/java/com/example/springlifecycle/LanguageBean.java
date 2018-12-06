package com.example.springlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("LanguageBeanLanguageBean LanguageBean ")
public class LanguageBean implements BeanNameAware,ApplicationContextAware {

    //自己的name在spring中
    private String myNameInSpring;
    @Override
    public void setBeanName(String s) {
            myNameInSpring=s;
    }

    public String getMyNameInSpring() {
        return myNameInSpring;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
