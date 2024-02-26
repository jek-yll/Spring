package com.example.correction_spring_aspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class TransactionAspect {

    @Autowired
    private static DataSourceTransactionManager transactionManager;

    @Pointcut("@annotation(com.example.correction_spring_aspect.annotation.Transaction)")
    public void transactionPointCut() {
    }

    @Around("transactionPointCut()")
    public Object transactionAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        Object object;
        try {
            object = joinPoint.proceed();
            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }

        return object;
    }
}
