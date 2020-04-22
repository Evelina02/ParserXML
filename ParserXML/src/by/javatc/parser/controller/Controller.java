package by.javatc.parser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.javatc.parser.controller.command.Command;
import by.javatc.parser.controller.command.CommandException;
import by.javatc.parser.controller.command.CommandHelper;
import by.javatc.parser.controller.constantname.JspPageName;
import by.javatc.parser.controller.constantname.RequestParameterName;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page = null;
		try {
			String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);
			Command command = CommandHelper.getInstance().getCommand(commandName);

			page = command.execute(request);
		} catch (CommandException e) {
			page = JspPageName.ERROR_PAGE;
		} catch (Exception e) {
			page = JspPageName.ERROR_PAGE;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} else {
			errorMessageDireclyFromResponse(response);
		}
	}

	private void errorMessageDireclyFromResponse(HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.getWriter().println("ERROR");
	}
	
}
