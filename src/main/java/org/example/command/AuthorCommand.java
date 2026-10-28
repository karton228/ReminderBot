package org.example.command;

public class AuthorCommand implements Command {

    @Override
    public String name() {
        return "author";
    }

    @Override
    public String description() {
        return "Информация об авторах проекта";
    }

    @Override
    public String detailedHelp() {
        return "Команда /author выводит имена и контакты авторов проекта.\n" +
                "Аргументы не требуются.";
    }

    @Override
    public String execute(String argument, long chatId) {
        return "👨‍💻 Авторы проекта:\n" +
                "• Морозова Софья — @sofkko\n" +
                "• Игнатова Кира — @hu1na228";
    }
}
