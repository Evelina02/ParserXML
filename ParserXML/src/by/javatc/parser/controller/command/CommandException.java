package by.javatc.parser.controller.command;

public class CommandException extends Exception{

	private static final long serialVersionUID = 2L;
	
	public CommandException() {}
	
	public CommandException(String message){
		super(message);
	}
	public CommandException(String message, Exception e){
		super(message, e);
	}
	
	public CommandException(Throwable cause) {
		super(cause);
	}
}
