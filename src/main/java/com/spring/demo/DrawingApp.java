package com.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
//        Triangle triangle = new Triangle();
//        BeanFactory factory = new XmlBeanFa ctory(new FileSystemResource("spring.xml"));
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
//        Shape triangle = (Shape) context.getBean("triangle");
//        triangle.draw();
        Shape circle = (Shape) context.getBean("circle");
        circle.draw();

//        System.out.println(context.getMessage("greeting", null, "Default greeting", null));
    }
}
