package com.alreylz.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCourseApplication.class, args);
    }





    // Required to be able to consume microservices from thymeleaf (STEP 1)
@Bean
    public RestTemplate restemplate(RestTemplateBuilder builder){
        return builder.build();
}

}
