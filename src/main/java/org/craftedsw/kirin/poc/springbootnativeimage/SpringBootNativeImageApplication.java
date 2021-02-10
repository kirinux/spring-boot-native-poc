package org.craftedsw.kirin.poc.springbootnativeimage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class SpringBootNativeImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNativeImageApplication.class, args);
    }

}
