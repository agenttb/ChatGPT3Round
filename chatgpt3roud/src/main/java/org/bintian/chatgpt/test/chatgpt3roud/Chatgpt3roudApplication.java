package org.bintian.chatgpt.test.chatgpt3roud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class
})
@ComponentScan(basePackages = {"org.bintian.chatgpt.test.chatgpt3roud"})
public class Chatgpt3roudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chatgpt3roudApplication.class, args);
	}

}
