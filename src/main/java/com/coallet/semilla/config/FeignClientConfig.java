package com.coallet.semilla.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FeignClientsConfiguration.class)
@EnableFeignClients("com.coallet.semilla.adapter.rest.feign")
public class FeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Level.BASIC;
    }

}
