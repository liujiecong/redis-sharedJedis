package com.miniso.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(value = "com.miniso.sso")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
