package com.bot.model;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "950171951:AAFuulPfTWyU_kouMnro3lQOo8EjIkl8Hks";
    }


    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();


        SendMessage sendMessage = new SendMessage();


        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("j");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "travelGodBot";
    }
}
