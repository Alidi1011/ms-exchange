package com.aarteaga.ms_exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsExchangeApplication.class, args);
	}

}
