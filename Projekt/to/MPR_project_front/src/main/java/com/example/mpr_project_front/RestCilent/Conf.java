package com.example.mpr_project_front.RestCilent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@ComponentScan
@Configuration
public class Conf {
    @Bean
    RestClient getRestClient(){
        return RestClient.builder().baseUrl("http://localhost:8081/").build();
    }
}