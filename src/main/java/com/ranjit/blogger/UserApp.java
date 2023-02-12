package com.ranjit.blogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ui.ModelMap;

 

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(UserApp.class, args);
    }
    
    
}
