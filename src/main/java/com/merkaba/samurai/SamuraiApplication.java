package com.merkaba.samurai;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {SamuraiApplication.class, Jsr310JpaConverters.class})
public class SamuraiApplication {

	@PostConstruct
	void init () {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Belgrade"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SamuraiApplication.class, args);
	}

}
