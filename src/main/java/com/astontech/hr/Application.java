package com.astontech.hr;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by chardeni1 on 8/5/2016.
 */
@SpringBootApplication
public class Application {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUserName;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.datasource.driverClassName}")
    private String datasourceDriverClassName;

    @Bean
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName(datasourceDriverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(datasourceUserName);
        ds.setPassword(datasourcePassword);

        return ds;
    }

    public static void main(String[] args) {




//        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//        for (String beanName : beanNames) {
//
//            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
//        }
        SpringApplication.run(Application.class, args);

    }
}
