package by.javatc.parser.controller.command.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import by.javatc.parser.bean.Dish;
import by.javatc.parser.bean.ParserType;
import by.javatc.parser.controller.command.Command;
import by.javatc.parser.controller.command.CommandException;
import by.javatc.parser.controller.constantname.JspPageName;
import by.javatc.parser.controller.constantname.RequestParameterName;
import by.javatc.parser.service.XMLService;
import by.javatc.parser.service.XMLServiceException;
import by.javatc.parser.service.XMLServiceFactory;

public class SaxParser implements Command {

	private static final String ERROR = "Your XML does not match the XSD scheme!";

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		
		String page = null;
		try {
			XMLService service = XMLServiceFactory.getInstance().getService(ParserType.SAX);
			List<Dish> dishes = service.parse(request.getParameter(RequestParameterName.FILE_NAME));
			
			if(dishes == null) {
				request.setAttribute(RequestParameterName.ERROR_MESSAGE, ERROR);
				page = JspPageName.FIRST_PAGE;
			}
			request.setAttribute(RequestParameterName.DISH_INFO, dishes);
			page = JspPageName.RESULT_PAGE;
		} catch (XMLServiceException e) {
			throw new CommandException("Error during signing in (getting service)", e);
		}
		return page;
	}

}
