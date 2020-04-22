package by.javatc.parser.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.xml.sax.SAXException;

import by.javatc.parser.bean.*;
import by.javatc.parser.dao.XMLDAOException;
import by.javatc.parser.dao.XMLDAOFactory;
import by.javatc.parser.dao.XMLDao;
import by.javatc.parser.service.XMLService;
import by.javatc.parser.service.XMLServiceException;
import by.javatc.parser.service.XmlValidator;

public class StaxXmlService implements XMLService {

	private static final StaxXmlService instance = new StaxXmlService();

	public static XMLService getInstance() {
		return instance;
	}

	@Override
	public List<Dish> parse(String resourceName) throws XMLServiceException{
		List<Dish> dishes = new ArrayList<Dish>();

		try {
			if (!XmlValidator.xsdSchemeValidate(resourceName)) {
				return null;
			}

			XMLDao dao = XMLDAOFactory.getInstance().getDAO(ParserType.STAX);
			dishes = dao.parse(resourceName);
		} catch (XMLDAOException e) {
			throw new XMLServiceException("Error during parsing(STAX)");
		} catch (IOException | SAXException e1) {
			throw new XMLServiceException("Error during parsing(STAX) xsd");

		}
		return dishes;
	}
	
}
