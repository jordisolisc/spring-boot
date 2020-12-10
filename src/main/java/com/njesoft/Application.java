package com.njesoft;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableBatchProcessing
@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:custom.properties"),
        @PropertySource(value = "classpath:custom_secrets.properties")
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
