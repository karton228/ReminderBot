package org.example.command;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Реестр всех команд бота.
 * HelpCommand берёт список команд отсюда — поэтому при добавлении
 * новой команды справка обновляется автоматически.
 */
public class CommandRegistry {

    private final Map<String, Command> commands = new LinkedHashMap<>();

    public void register(Command command) {
        commands.put(command.name(), command);
    }

    public Optional<Command> get(String name) {
        return Optional.ofNullable(commands.get(name));
    }

    public Collection<Command> getAll() {
        return commands.values();
    }

    public boolean contains(String name) {
        return commands.containsKey(name);
    }
}
