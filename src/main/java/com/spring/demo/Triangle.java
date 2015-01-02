package com.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape {

    /*private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }*/

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void draw() {
//        System.out.printf("%s triangle has drawn of height %d!!!!!%n", getType(), getHeight());
        System.out.println("Drawing Triangle:");
        System.out.printf("point A = %s, %s%n", getPointA().getX(), getPointA().getY());
        System.out.printf("point B = %s, %s%n", getPointB().getX(), getPointB().getY());
        System.out.printf("point C = %s, %s%n", getPointC().getX(), getPointC().getY());
        /*for (Point point : points) {
            System.out.printf("Point = (%s, %s)%n", point.getX(), point.getY());
        }*/
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing init() method called for Triangle");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable destroy() method called for Triangle");
    }

    /*private String type;
    private int height;

    public Triangle(String type) {
        this.type = type;
    }

    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }

    public Triangle(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }*/
}
