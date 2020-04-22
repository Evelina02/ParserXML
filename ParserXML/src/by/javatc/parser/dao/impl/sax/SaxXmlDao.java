package by.javatc.parser.dao.impl.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.javatc.parser.bean.*;
import by.javatc.parser.dao.XMLDAOException;
import by.javatc.parser.dao.XMLDao;

public class SaxXmlDao implements XMLDao {

	private static final SaxXmlDao instance = new SaxXmlDao();
	

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Dish> parse(String resourceName) throws XMLDAOException {

		List<Dish> dishes = new ArrayList<Dish>();
		try {

			XMLReader reader = XMLReaderFactory.createXMLReader();
			SAXParser handler = new SAXParser();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(resourceName));

			dishes = handler.getDishList();

		} catch (SAXException | IOException e) {
			throw new XMLDAOException("Error during parsing(SAX)");
		}
		return dishes;
	}

}
