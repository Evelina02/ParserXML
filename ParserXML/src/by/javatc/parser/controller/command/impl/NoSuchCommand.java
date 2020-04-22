package by.javatc.parser.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.javatc.parser.controller.command.Command;
import by.javatc.parser.controller.command.CommandException;
import by.javatc.parser.controller.constantname.JspPageName;

public class NoSuchCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		return JspPageName.ERROR_PAGE;
	}

}
