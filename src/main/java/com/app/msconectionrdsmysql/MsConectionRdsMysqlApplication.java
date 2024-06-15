package com.app.msconectionrdsmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.app.msconectionrdsmysql.repository")
public class MsConectionRdsMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsConectionRdsMysqlApplication.class, args);
    }

}
