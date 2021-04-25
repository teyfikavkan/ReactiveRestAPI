package org.example.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static org.example.reactive.constant.ProjectConstants.BASE_PACKAGES;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {BASE_PACKAGES})
public class ReactiveRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveRestApiApplication.class, args);
    }
}
