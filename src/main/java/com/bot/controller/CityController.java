package com.bot.controller;

import com.bot.dto.CityOutput;
import com.bot.model.City;
import com.bot.service.CityService;
import name.maratik.spring.telegram.annotation.TelegramBot;
import name.maratik.spring.telegram.annotation.TelegramCommand;
import name.maratik.spring.telegram.annotation.TelegramHelp;
import name.maratik.spring.telegram.annotation.TelegramMessage;
import name.maratik.spring.telegram.model.TelegramMessageCommand;
import name.maratik.spring.telegram.util.Localizable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

@TelegramBot
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private Localizable localizable;

    @TelegramMessage
    public SendMessage defaultAction(long userId, User user, String message) {
        CityOutput city;
        try{
            city = cityService.getByName(message);
        }catch (RuntimeException ex){
            return new SendMessage()
                    .setChatId(userId)
                    .setText(String.format("No correct value. Please use /city command"));
        }
        return new SendMessage()
                .setChatId(userId).setText(city.toString());
                //.setText(String.format(" %s, it is for you \n %s \n %s" , user.getFirstName(), city.getDescription(),city.getUrl()));

    }

    @TelegramCommand(commands = "/some_command", description = "Some command")
    public SendMessage someCommand(long userId, TelegramMessageCommand telegramMessageCommand) {
        return new SendMessage()
                .setChatId(userId)
                .setText(String.format("You've send me %s command with arguments: %s",
                        telegramMessageCommand.getCommand(), telegramMessageCommand.getArgument()
                ));
    }

    @TelegramCommand(commands = "/city", description = "Some command")
    public SendMessage listCity(long userId, TelegramMessageCommand telegramMessageCommand) {
        Locale locale = new Locale("ru_RU");
        LocaleContextHolder.setLocale(locale);
        LocaleContextHolder.getLocale();
       ArrayList<String> cities =   cityService.getAll().stream().map(CityOutput::getName).collect(Collectors.toCollection(ArrayList::new));
        return new SendMessage()
                .setChatId(userId)
                .setText(String.format("Our cities %s ",
                        cities));
    }

    @TelegramHelp
    public String helpPrefix() {
        return "This text will be prefixed at /help command\n";
    }


    @TelegramCommand(commands = "/language", description = "#{@loc?.t('language.change')}")
    public SendMessage listCity2(long userId, TelegramMessageCommand telegramMessageCommand) {
        Locale locale = new Locale("ru_RU");
        LocaleContextHolder.setLocale(locale);
        LocaleContextHolder.getLocale();
        ArrayList<String> cities =   cityService.getAll().stream().map(CityOutput::getName).collect(Collectors.toCollection(ArrayList::new));
        return new SendMessage()
                .setChatId(userId)
                .setText(String.format("Our cities %s ",
                        cities));
    }

}
