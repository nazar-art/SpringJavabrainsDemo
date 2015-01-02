package com.spring.database;

import com.spring.database.dao.HibernateDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-db.xml");
//        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
//        JdbcSupportImpl dao = context.getBean("jdbcSupportImpl", JdbcSupportImpl.class);
        HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

//        Circle circle = dao.getCircle(1);
//        System.out.println(circle.getName());
//        System.out.println("COUNT OF ROW AT circle table: " + dao.getCircleCount());
//        System.out.println("Circle name: " + dao.getCircleName(1));
//        System.out.println("Circle: " + dao.getCircleById(1));
//        dao.insertCircle(new Circle(8, "Eight Circle"));
//        System.out.println("All Circles count: " + dao.getAllCircles().size());
        System.out.println("All Circles count: " + dao.getCircleCount());
//        dao.createTriangleTable();
    }
}
