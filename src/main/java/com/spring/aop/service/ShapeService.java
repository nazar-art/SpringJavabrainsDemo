package com.spring.aop.service;

import com.spring.aop.aspect.Loggable;
import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Circle getCircle() {
        System.out.println("Circle Getter called");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
