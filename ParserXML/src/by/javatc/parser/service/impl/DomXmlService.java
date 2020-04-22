package by.javatc.parser.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.javatc.parser.bean.*;
import by.javatc.parser.dao.XMLDAOException;
import by.javatc.parser.dao.XMLDAOFactory;
import by.javatc.parser.dao.XMLDao;
import by.javatc.parser.service.XMLService;
import by.javatc.parser.service.XMLServiceException;
import by.javatc.parser.service.XmlValidator;

public class DomXmlService implements XMLService {

	private static final DomXmlService instance = new DomXmlService();

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

			XMLDao dao = XMLDAOFactory.getInstance().getDAO(ParserType.DOM);
			dishes = dao.parse(resourceName);
		} catch (XMLDAOException e) {
			throw new XMLServiceException("Error during parsing(DOM)");
		} catch (IOException | SAXException e1) {
			throw new XMLServiceException("Error during parsing(DOM) xsd");

		}
		return dishes;
	}	
	
}
