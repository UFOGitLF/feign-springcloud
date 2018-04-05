package com.fly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author liufei
 */
@SpringBootApplication
@EnableFeignClients
public class ApplyApplication {

    private static final Logger log = LoggerFactory.getLogger(ServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplyApplication.class, args);
        log.info("apply is running!!!");
    }
}
