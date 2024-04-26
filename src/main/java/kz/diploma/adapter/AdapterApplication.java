package kz.diploma.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
	}

}
