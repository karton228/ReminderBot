package org.example;


/**
 * Логика работы бота
 */
public class BotLogic {
    public String makeMessage(String text, long chatId){
        return switch(text){
            case "/start"->"Привет друн!";
            case "/help"->"МОТОРОЛЛА";
            default->"ты написал: " + text; //соня ты это всё дописываешь и тд
        };
    }
}
