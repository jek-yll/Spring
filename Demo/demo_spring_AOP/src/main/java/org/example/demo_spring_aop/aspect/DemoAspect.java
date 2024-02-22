package org.example.demo_spring_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {


    //* com.example.demo_spring_aop.service.*.*(..) => la totalité des méthodes des classes du package service avec n'importe quel argument
    /*@Before("execution(* com.example.demo_spring_aop.service.*.*(..))")
    public void addActionBefore() {
        System.out.println("Action executed by Aspect");
    }

    @After("execution(* com.example.demo_spring_aop.service.*.*(..))")
    public void addActionAfter() {
        System.out.println("Action executed after by Aspect");
    }

    @AfterReturning("execution(* com.example.demo_spring_aop.service.*.*(..))")
    public void addActionAfterReturning() {
        System.out.println("Action executed after Returning value by Aspect");
    }

    @AfterThrowing("execution(* com.example.demo_spring_aop.service.*.*(..))")
    public void addActionAfterThrowing() {
        System.out.println("Action executed after Throwing exception by Aspect");
    }*/

    @Around("execution(* org.example.demo_spring_aop.service.*.*(..))")
    public void addActionAround(ProceedingJoinPoint joinPoint)  {
        try {
            //Avant
            System.out.println("Start Around");
            //Execute
            //Récupérer les arguments
            Object[] args = joinPoint.getArgs();
            // Utiliser les arguments de la méthode
            joinPoint.proceed();
        }catch (Exception ex) {
            //Après
            System.out.println("End Around");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Pointcut("@annotation(org.example.demo_spring_aop.annotation.CustomAnnotation)")
    public void customAnnotationPointCut(){}
    @Before("customAnnotationPointCut()")
    public void methodAspectWithAnnotation(){
        System.out.println("Aspect run before method with annotation");
    }
}
