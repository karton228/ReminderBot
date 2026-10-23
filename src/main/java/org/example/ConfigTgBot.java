package org.example;

import java.io.InputStream;
import java.util.Properties;


/**
 * Предоставляет доступ к токену и имени бота для его конфигурации (запуска)
 */
public class ConfigTgBot {
    /**
     * Нужно для хранения данных в файле - токена и имени бота
     */
    private Properties properties;
    ConfigTgBot(){
        properties = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("token.properties")){
            if (input == null){
                throw new RuntimeException("Файл не найден");
            }
            properties.load(input);
        } catch(Exception err){
            throw new RuntimeException("Проблема с конфигурацией");
        }
    }

    public String getBotName(){
        return properties.getProperty("tgBotName");
    }
    public String getBotToken(){
        return properties.getProperty("tgBotToken");
    }
}
