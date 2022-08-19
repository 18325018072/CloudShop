package com.kevin;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Kevin2
 */
@SpringBootApplication
public class GatewayApplication {
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
