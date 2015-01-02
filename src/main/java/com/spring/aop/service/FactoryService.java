package com.spring.aop.service;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class FactoryService {

    public Object getBean(String beanType) {
        if (beanType.equalsIgnoreCase("shapeService")) {
            return new ShapeServiceProxy();
        } else if (beanType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (beanType.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }
        return null;
    }
}
