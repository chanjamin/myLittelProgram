package com.example;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //spring 调用MySelector.selectImports
        System.out.println(importingClassMetadata.getAllAnnotationAttributes(EnableLog.class.getName()).get("valueToLog"));
        return new String[]{"com.example.Book"};
    }
}
