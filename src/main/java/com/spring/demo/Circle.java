package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;

    @Autowired
    private MessageSource messageSource;

    private ApplicationEventPublisher publisher;

    public Point getCenter() {
        return center;
    }

    @Autowired
//    @Qualifier("circleRelated")
    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void draw() {
//        System.out.printf("Circle Point is: (%d, %d)%n", center.getX(), center.getY());
        System.out.println(messageSource.getMessage("drawing.circle", null, "Default drawing message", null));
        System.out.println(messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default point message", null));
        System.out.println(messageSource.getMessage("greeting", null, "Default greeting", null));
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
