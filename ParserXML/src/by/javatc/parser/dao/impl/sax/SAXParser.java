package by.javatc.parser.dao.impl.sax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.javatc.parser.bean.Category;
import by.javatc.parser.bean.Dish;
import by.javatc.parser.dao.impl.RestaurantTagName;

public class SAXParser extends DefaultHandler {

	private List<Dish> dishList = new ArrayList<Dish>();
	private Dish dish;
	private StringBuilder text;
	private Set<String> ingredients;

	
	
	public List<Dish> getDishList() {
		return dishList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Start parse XML...");
	}

	public void endDocument() throws SAXException {
		System.out.println("Stop parse XML...");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);

		text = new StringBuilder();
		if (qName.equals("dish")) {
			dish = new Dish();
			dish.setId(attributes.getValue("id"));
			dish.setName((attributes.getValue("name")));
			dish.setPicture((attributes.getValue("picture")));
			dish.setAmount((attributes.getValue("amount")));
		}
		if (qName.equals("category")) {
			dish.setCategory(Category.valueOf(attributes.getValue("name")));
		}
		if (qName.equals("ingredients")) {
			ingredients = new HashSet<>();
		}
		if (qName.equals("ingredient")) {
			ingredients.add(attributes.getValue("name"));
		}
		
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
		
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		RestaurantTagName tagName = RestaurantTagName.valueOf(qName.toUpperCase());
		switch (tagName) {
		case PRICE:
			dish.setPrice(Double.parseDouble(text.toString()));
			break;
		case INGREDIENTS:
			dish.setIngredients(ingredients);
			ingredients = null;
			break;
		case DISH:
			dishList.add(dish); 
			dish = null;
		break;
			
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}

	
}
