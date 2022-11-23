package com.alreylz.springbootcourse.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Component
public class EndpointsListener {
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("-------------------------\n" +
                "ACTIVE ENDPOINTS\n-------------------------");
//        ApplicationContext applicationContext = event.getApplicationContext();
//        applicationContext.getBean(RequestMappingHandlerMapping.class)
//                .getHandlerMethods().forEach((key, value) -> System.out.println(" " + key + " at: " + value));

        ApplicationContext applicationContext = event.getApplicationContext();
        applicationContext.getBean(RequestMappingHandlerMapping.class)
                .getHandlerMethods().forEach((key, value) -> System.out.println(" " + key));
    }
}
