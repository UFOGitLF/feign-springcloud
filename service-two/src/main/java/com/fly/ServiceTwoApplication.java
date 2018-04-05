package com.fly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author liufei
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class ServiceTwoApplication {

    private static final Logger log = LoggerFactory.getLogger(ServiceTwoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApplication.class, args);
        log.info("eureka second service is running!!!");
    }
}
