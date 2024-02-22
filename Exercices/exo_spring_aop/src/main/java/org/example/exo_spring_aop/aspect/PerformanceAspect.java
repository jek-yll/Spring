package org.example.exo_spring_aop.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @AfterReturning("execution(* org.example.exo_spring_aop.service.*.*(..)))")
    public void performance() {
        System.out.println("Perf : " + System.currentTimeMillis());
    }

}
