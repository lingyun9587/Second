package com.example.demo;


import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

  
  @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
    
    return application.sources(DemoApplication.class);
  
  }


}
