package com.alreylz.springbootcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * Esta clase debe ser descomentada si queremos trabajar con Thymeleaf Y JSPs simultáneamente.
 */


//
//@Configuration
//public class Config {
//    @Autowired
//    WebApplicationContext webApplicationContext;
//
//    @Bean
//    public SpringResourceTemplateResolver thymeleafTemplateResolver(){
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(webApplicationContext);
//        templateResolver.setOrder(9);
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix("");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine springTemplateEngine= new SpringTemplateEngine();
//        springTemplateEngine.setTemplateResolver(thymeleafTemplateResolver());
//        springTemplateEngine.setEnableSpringELCompiler(true);
//        return springTemplateEngine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver(){
//        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setViewNames(new String[] {"*.html"});
//        viewResolver.setExcludedViewNames(new String[] {"*.jsp"});
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//        return viewResolver;
//    }
//
//    @Bean
//    public InternalResourceViewResolver jspViewResolver(){
//        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setOrder(10);
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix("");
//        viewResolver.setViewNames("*.jsp");
//        return viewResolver;
//    }
//}
