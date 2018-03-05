package com.dulval.demo.heroapi;

import com.dulval.demo.heroapi.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class HeroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroApiApplication.class, args);
    }

    @Autowired
    public HeroApiApplication(RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Hero.class);
    }
}
