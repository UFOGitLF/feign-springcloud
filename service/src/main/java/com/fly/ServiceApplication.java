package com.fly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

/**
 * @author liufei
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class ServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(ServiceApplication.class);

    /** Ribbon 负载均衡 */
    /**@Bean
       @LoadBalanced
       public RestTemplate restTemplate(){
         return new RestTemplate();
    }**/

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
        log.info("service is running!!!");
    }
}
