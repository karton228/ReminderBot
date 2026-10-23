package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Класс для работы с телеграмм API
 */
public class TgBot extends TelegramLongPollingBot {
    private final String botUserName;
    private final BotLogic botLogic = new BotLogic();

    /**
     * Конструктор тгбот
     * @param botUserName имя бота
     * @param token       токен бота
     */
    TgBot(String botUserName, String token){
        this.botUserName = botUserName;
        super(token);
    }

    /**
     * геттер имя бота
     * @return   клянусь имя бота возвращает
     */
    @Override
    public String getBotUsername(){
        return botUserName;
    }

    /**
     * метод для обработки и принятия событий телеграмма 0_0
     * @param update Update received
     */
    @Override
    public void onUpdateReceived(Update update){
        if (update.getMessage() == null){
            return;
        }
        Message message = update.getMessage();
        if (!message.hasText()){
            return;
        }
        String text = message.getText();   //текст = это текст
        long chatId = message.getChatId();  // чат айди = юзернейм пользователя (например hu1na228)
        String answer = botLogic.makeMessage(text, chatId); //соня мейк месседж ты пишешь. (._.)
        sendMessage(answer, chatId);
    }


    /**
     * Метод для отправки ответного сообщения
     * @param answer  ответ
     * @param chatId  юзернейм пользователя
     */
    private void sendMessage(String answer, long chatId){
        SendMessage reply = new SendMessage();
        reply.setChatId(chatId);
        reply.setText(answer);
        try{
            execute(reply);
        } catch(TelegramApiException err){
            System.err.println("Ашибка" + err.getMessage());
        }
    }
}

