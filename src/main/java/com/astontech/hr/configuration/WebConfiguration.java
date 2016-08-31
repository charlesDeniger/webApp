package com.astontech.hr.configuration;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chardeni1 on 8/5/2016.
 */
@Configuration
public class WebConfiguration {

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
        registrationBean.addUrlMappings("/console/*");

        return registrationBean;
    }

}