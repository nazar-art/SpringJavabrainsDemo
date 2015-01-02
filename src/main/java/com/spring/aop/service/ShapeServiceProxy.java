package com.spring.aop.service;

import com.spring.aop.aspect.LoggingAspect;
import com.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
    @Override
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }
}
