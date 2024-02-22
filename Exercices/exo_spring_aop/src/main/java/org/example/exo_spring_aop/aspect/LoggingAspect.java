package org.example.exo_spring_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* org.example.exo_spring_aop.service.*.*(..)))")
    public void log(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Log : " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    " // Arg :" + Arrays.toString(joinPoint.getArgs())) ;

            joinPoint.proceed();

            System.out.println("Log : " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                    " // Return :" + joinPoint.proceed().toString());

        } catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}
