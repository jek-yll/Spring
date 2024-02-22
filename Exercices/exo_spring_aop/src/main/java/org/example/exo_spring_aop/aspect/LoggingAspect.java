package org.example.exo_spring_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.exo_spring_aop.annotation.PerformAnnotation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(org.example.exo_spring_aop.annotation.LoggerAnnotation)")
    public void loggerAnnotationPointCut(){}


    //@Around("execution(* org.example.exo_spring_aop.service.*.*(..)))")
    @Around("loggerAnnotationPointCut()")
    public void log(ProceedingJoinPoint joinPoint) {

        try {

            System.out.println("Log : " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    " // Arg :" + Arrays.toString(joinPoint.getArgs())) ;

            Object retour = joinPoint.proceed();

            System.out.println("Log : " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    " // Return :" + retour.toString());

        } catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}
