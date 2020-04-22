package by.javatc.parser.dao.impl.dom;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.javatc.parser.bean.*;
import by.javatc.parser.dao.XMLDAOException;
import by.javatc.parser.dao.XMLDao;
import by.javatc.parser.dao.impl.RestaurantTagName;

public class DomXmlDao implements XMLDao {

	private static final DomXmlDao instance = new DomXmlDao();
	

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Dish> parse(String resourceName) throws XMLDAOException {

		List<Dish> dishes = new ArrayList<Dish>();
		Set<String> ingredients = null;
		try {
			DOMParser parser = new DOMParser();

			parser.parse(resourceName);

			Document document = parser.getDocument();
			Element root = document.getDocumentElement();

			NodeList dishNodes = root.getElementsByTagName("dish");
			Dish dish = null;
			for (int i = 0; i < dishNodes.getLength(); i++) {
				dish = new Dish();
				Element dishElement = (Element) dishNodes.item(i);

				dish.setId(dishElement.getAttribute("id"));
				dish.setName(dishElement.getAttribute("name"));
				dish.setPicture(dishElement.getAttribute("picture"));
				dish.setAmount(dishElement.getAttribute("amount"));

				dish.setCategory(Category.valueOf(getSingleChild(dishElement, "category").getAttribute("name")));

				dish.setPrice(Double.parseDouble(getSingleChild(dishElement, "price").getTextContent().trim()));

//		Element ingrediends = getSingleChild(dishElement,"ingredients").getTextContent().trim());

				NodeList ingredientsNodes = dishElement.getElementsByTagName("ingredient");
				if (ingredientsNodes != null) {
					ingredients = new HashSet<>();
					for (int j = 0; j < ingredientsNodes.getLength(); j++) {
						Element ingredientElement = (Element) ingredientsNodes.item(j);

						ingredients.add(ingredientElement.getAttribute("name"));
					}
					dish.setIngredients(ingredients);
					ingredients = null;

				}
				dishes.add(dish);
			}

		} catch (SAXException | IOException e) {
			throw new XMLDAOException("Error during parsing(DOM)");
		}

		return dishes;
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
