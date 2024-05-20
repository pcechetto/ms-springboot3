package com.example.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HrUserApplication  {

	// implements CommandLineRunner
	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	System.out.println("BCRYPT= " + passwordEncoder.encode("123456"));
	// }

}
