package kz.diploma.adapter;

import kz.diploma.library.shared.error_handling.ErrorHandlingAutoConfiguration;
import kz.diploma.library.shared.jooq.JooqAutoConfiguration;
import kz.diploma.library.shared.model.ModelsAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import(value = {JooqAutoConfiguration.class, ErrorHandlingAutoConfiguration.class, ModelsAutoConfiguration.class})
public class AdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
	}

}
