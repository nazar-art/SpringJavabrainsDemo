package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class LoggingAspect {

/*//    @Before("execution(public String com.spring.aop.model.Circle.getName())")
    @Before("allCircleMethods()") // using wildcard * => one or more .. => zero of more
    public void LoggingAdvice(JoinPoint joinPoint) {
//        System.out.println("Advice run. Get method called");
//        System.out.println(joinPoint.toString());
        Circle circle = (Circle) joinPoint.getTarget();
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethods(String name, String returnString) {
        System.out.printf("A method that takes string arguments has been called. The value is: %s. The output value is: %s%n", name, returnString);
    }

    *//*@Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second advise executed");
    }*//*

    @AfterThrowing(value = "args(name)", throwing = "ex")
    public void afterAdvice(String name, Throwable ex) {
        System.out.println("An exception has thrown: " + ex);
    }

    @Pointcut("within(com.spring.aop.model.Circle)")
    public void allCircleMethods() {

    }*/

    @Pointcut("execution(* get*())")
    public void allGetters() {

    }

//    @Around("@annotation(com.spring.aop.aspect.Loggable)")
//    @Around("allGetters()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;
        try {
            System.out.println("Before advice");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("After returning");
        } catch (Throwable throwable) {
            System.out.println("After Throwing");
//            throwable.printStackTrace();
        }
        System.out.println("After finally");
        return returnValue;
    }

    public void loggingAdvice() {
        System.out.println("Into logging advice");
    }
}
