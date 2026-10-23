package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Точка входа в программу
 */
public class TgBotMain {
    public static void main(String[] args) throws TelegramApiException{
        ConfigTgBot config = new ConfigTgBot();
        String tgBotName = config.getBotName();
        String tgBotToken = config.getBotToken();
        TgBot reminderBot = new TgBot(tgBotName, tgBotToken);
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(reminderBot);
    }
}
