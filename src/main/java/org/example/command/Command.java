package org.example.command;

/**
 * Общий контракт для всех команд бота.
 * Благодаря ему HelpCommand автоматически строит справку,
 * а BotLogic не знает о конкретных командах.
 */
public interface Command {
    String name();
    String description();
    String detailedHelp();
    String execute(String argument, long chatId);
}
