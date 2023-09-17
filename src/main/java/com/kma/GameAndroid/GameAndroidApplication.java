package com.kma.GameAndroid;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API app hotel",
				version = "1.0.0",
				description = "Api sử dụng trong app khách sạn.",
				contact = @Contact(
						name = "QuangDuong",
						email = "quangduong19992001@gmail.com"
				),
				license = @License(
						name = "Link: license ",
						url = "https://www.youtube.com/watch?v=m1M1V9hdL3c"
				)
		)
)
public class GameAndroidApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameAndroidApplication.class, args);
	}

}
