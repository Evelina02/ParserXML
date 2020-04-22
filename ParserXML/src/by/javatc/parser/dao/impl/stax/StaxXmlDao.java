package by.javatc.parser.dao.impl.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.javatc.parser.bean.*;
import by.javatc.parser.dao.XMLDAOException;
import by.javatc.parser.dao.XMLDao;
import by.javatc.parser.dao.impl.RestaurantTagName;

public class StaxXmlDao implements XMLDao {

	private static final StaxXmlDao instance = new StaxXmlDao();
	

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Dish> parse(String resourceName) throws XMLDAOException {

		List<Dish> dishes = new ArrayList<Dish>();

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream(resourceName);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			dishes = process(reader);

		} catch (XMLStreamException e) {
			throw new XMLDAOException("Error during parsing(STAX)");
		} catch (FileNotFoundException e) {
			throw new XMLDAOException("Error during getting file!");
		}
		return dishes;
	}

	private static List<Dish> process(XMLStreamReader reader) throws XMLStreamException {
		List<Dish> dishes = new ArrayList<Dish>();
		Set<String> ingredients = null;
		Dish dish = null;
		RestaurantTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = RestaurantTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case DISH:
					dish = new Dish();
					String id = reader.getAttributeValue(null, "id");
					String name = reader.getAttributeValue(null, "name");
					String picture = reader.getAttributeValue(null, "picture");
					String amount = reader.getAttributeValue(null, "amount");

					dish.setId(id);
					dish.setName(name);
					dish.setPicture(picture);
					dish.setAmount(amount);

					break;

				case CATEGORY:
					dish.setCategory(Category.valueOf(reader.getAttributeValue(null, "name")));
					break;

				case INGREDIENTS:
					ingredients = new HashSet<>();

					break;

				case INGREDIENT:
					ingredients.add((reader.getAttributeValue(null, "name")));
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {

				case PRICE:
					dish.setPrice(Double.parseDouble(text));
					break;
				}

				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = RestaurantTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {

				case INGREDIENTS:
					dish.setIngredients(ingredients);
					break;

				case DISH:
					dishes.add(dish);
				}
			}
		}
		return dishes;
	}
}
