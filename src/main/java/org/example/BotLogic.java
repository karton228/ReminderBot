package org.example;

import org.example.command.AboutCommand;
import org.example.command.AuthorCommand;
import org.example.command.CommandRegistry;
import org.example.command.HelpCommand;
import org.example.command.StartCommand;

/**
 * Диспетчер сообщений: разбирает текст и вызывает нужную команду.
 * Сама логика команд — в классах пакета org.example.command.
 */
public class BotLogic {

    private final CommandRegistry registry;

    public BotLogic() {
        this.registry = new CommandRegistry();

        // Регистрируем команды. Новая команда -> регистрируем здесь -> /help обновится сам.
        registry.register(new StartCommand());
        registry.register(new AuthorCommand());
        registry.register(new AboutCommand());
        registry.register(new HelpCommand(registry));
    }

    /**
     * Обработать текстовое сообщение и вернуть ответ.
     */
    public String makeMessage(String text, long chatId) {
        if (text == null || text.isBlank()) {
            return "Пустое сообщение. Введите /help.";
        }
        if (!text.startsWith("/")) {
            return "Я понимаю только команды. Введите /help.";
        }

        // "/help author" -> name="help", arg="author"
        String withoutSlash = text.substring(1).trim();
        String[] parts = withoutSlash.split("\\s+", 2);
        String name = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : "";

        // Telegram может присылать "/help@MyBot" — обрезаем @username
        int at = name.indexOf('@');
        if (at > 0) {
            name = name.substring(0, at);
        }

        return registry.get(name)
                .map(cmd -> cmd.execute(argument, chatId))
                .orElse("Неизвестная команда: /" + name + "\n" +
                        "Используйте /help для списка команд.");
    }
}