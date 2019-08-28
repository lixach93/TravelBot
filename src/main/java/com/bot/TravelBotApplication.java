package com.bot;

import name.maratik.spring.telegram.annotation.EnableTelegramBot;
import name.maratik.spring.telegram.annotation.TelegramBot;
import name.maratik.spring.telegram.annotation.TelegramCommand;
import name.maratik.spring.telegram.annotation.TelegramMessage;
import name.maratik.spring.telegram.config.TelegramBotBuilder;
import name.maratik.spring.telegram.config.TelegramBotType;
import name.maratik.spring.telegram.model.TelegramMessageCommand;
import name.maratik.spring.telegram.util.Localizable;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;

@SpringBootApplication
@EnableTelegramBot
public class TravelBotApplication {

	@Bean
	public TelegramBotType telegramBotType() {
		return TelegramBotType.LONG_POLLING;
	}

	@Bean
	public Localizable loc() {
		return new Localizable();

	}
	@Bean
	public TelegramBotBuilder telegramBotBuilder() {
		return new TelegramBotBuilder()
				.username("travelGodBot")
				.token("950171951:AAFuulPfTWyU_kouMnro3lQOo8EjIkl8Hks");
	}

	public static void main(String[] args) {

		SpringApplication.run(TravelBotApplication.class, args);
	}



}
