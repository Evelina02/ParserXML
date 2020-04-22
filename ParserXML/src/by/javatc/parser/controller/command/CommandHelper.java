package by.javatc.parser.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.javatc.parser.controller.command.impl.*;

public class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();
	
	private final Map <CommandName, Command> commands = new HashMap<>();
	
	public CommandHelper() {
		
		commands.put(CommandName.SAX_PARSER, new SaxParser());
		commands.put(CommandName.STAX_PARSER, new StaxParser());
		commands.put(CommandName.DOM_PARSER, new DomParser());

		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
	}
	
	public static CommandHelper getInstance() {
		
		return instance;
	}
	
	public Command getCommand(String commandName) throws CommandException {
		
		CommandName name = null;
		Command command = null;
		
		try {
			name = CommandName.valueOf(commandName.toUpperCase());
			command = commands.get(name);
		} catch(IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
			throw new CommandException("Error! Incorrect request"); //???
		}
		return command;
	}


}
