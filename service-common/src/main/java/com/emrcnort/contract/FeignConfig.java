package com.emrcnort.contract;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.emrcnort")
public class FeignConfig {
}
