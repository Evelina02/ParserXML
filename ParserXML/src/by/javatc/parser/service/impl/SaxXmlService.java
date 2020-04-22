package by.javatc.parser.service.impl;

import java.io.IOException;
import java.io.InputStream;
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

public class SaxXmlService implements XMLService {

	private static final SaxXmlService instance = new SaxXmlService();

	public static XMLService getInstance() {
		return instance;
	}

	@Override
	public List<Dish> parse(String resourceName) throws XMLServiceException {

		List<Dish> dishes;
		try {
			if (!XmlValidator.xsdSchemeValidate(resourceName)) {
				return null;
			}

			dishes = new ArrayList<Dish>();
			XMLDao dao = XMLDAOFactory.getInstance().getDAO(ParserType.SAX);
			dishes = dao.parse(resourceName);
		} catch (XMLDAOException e) {
			throw new XMLServiceException("Error during parsing(SAX)");
		} catch (SAXException | IOException e1) {
			throw new XMLServiceException("Error during parsing(SAX)");

		}
		return dishes;
	}

}
