package com.nss.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

//    @GetMapping("/buyer")
//    @PreAuthorize("hasRole('ROLE_buyer')")
//    public String buyer()
//    {
//        return "Buyer endpoint";
//    }
//
//    @GetMapping("/seller")
//    @PreAuthorize("hasRole('ROLE_seller')")
//    public String customer()
//    {
//        return "Customer endpoint";
//    }
}
