package com.yuan.luck.gateway;

import com.yuan.luck.gateway.resolver.IPKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    
    public static void main(String[] args) {
        
        
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean("ipKeyResolver")
    public IPKeyResolver ipKeyResolver(){
        return new IPKeyResolver();
    }
    
    
}
