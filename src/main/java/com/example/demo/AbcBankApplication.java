package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController

@SpringBootApplication
@EnableWebMvc
@Configuration
@ComponentScan({"com.slk.*"})

public class AbcBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBankApplication.class, args);
	}

}
