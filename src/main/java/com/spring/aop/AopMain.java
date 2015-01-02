package com.spring.aop;

import com.spring.aop.service.FactoryService;
import com.spring.aop.service.ShapeService;

public class AopMain  {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
//        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
//        shapeService.getCircle().setNameAndReturn("Awesome Circle name");
//        shapeService.getCircle().setName("Awesome Circle name");
        FactoryService factoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");

        shapeService.getCircle();
//        System.out.println(shapeService.getCircle().getName());
    }
}
