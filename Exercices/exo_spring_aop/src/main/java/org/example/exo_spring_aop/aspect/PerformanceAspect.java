package org.example.exo_spring_aop.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Pointcut("@annotation(org.example.exo_spring_aop.annotation.PerformAnnotation)")
    public void performAnnotationPointCut(){}

    // @After("execution(* org.example.exo_spring_aop.service.*.*(..)))")
    @After("performAnnotationPointCut()")
    public void performance() {
        System.out.println("Perf : " + System.currentTimeMillis());
    }

}
