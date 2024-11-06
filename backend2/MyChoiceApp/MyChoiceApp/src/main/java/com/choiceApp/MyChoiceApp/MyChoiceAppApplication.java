package com.choiceApp.MyChoiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MyChoiceAppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().filename("/MyChoiceApp/MyChoiceApp/database.env").load();

		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
		System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
		System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));

		SpringApplication.run(MyChoiceAppApplication.class, args);
	}

}
