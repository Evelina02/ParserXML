package by.javatc.parser.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


public class XmlValidator {

	public static boolean xsdSchemeValidate(String xml) throws IOException, SAXException {
		{

			SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File schemaLocation = new File("D:\\ParserXML\\src\\resources\\restaurant.xsd");
			Schema schema = factory.newSchema(schemaLocation);

			Validator validator = schema.newValidator();
			Source source = new StreamSource(xml);
			try {
				validator.validate(source);
				return true;
			} catch (SAXException ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		}
	}
}
