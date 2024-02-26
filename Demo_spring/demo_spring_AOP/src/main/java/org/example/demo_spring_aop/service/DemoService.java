package org.example.demo_spring_aop.service;

import org.example.demo_spring_aop.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method() {
        /*System.out.println("----BB-----");
        methodReturnBoolean();
        */
        System.out.println("Method demoService");
        throw new RuntimeException();
    }

    public boolean methodReturnBoolean() {
        System.out.println("Method demoService Return Boolean");
        return true;
    }

    @CustomAnnotation
    public void methodWithAnnotation(){
        System.out.println("Method with Annotation Custom");
    }

}
