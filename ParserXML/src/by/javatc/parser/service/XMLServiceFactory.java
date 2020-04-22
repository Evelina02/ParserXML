package by.javatc.parser.service;

import by.javatc.parser.bean.ParserType;
import by.javatc.parser.dao.impl.dom.DomXmlDao;
import by.javatc.parser.dao.impl.stax.StaxXmlDao;
import by.javatc.parser.service.impl.DomXmlService;
import by.javatc.parser.service.impl.SaxXmlService;
import by.javatc.parser.service.impl.StaxXmlService;

public class XMLServiceFactory {

	private static final XMLServiceFactory instance = new XMLServiceFactory();

	public static XMLServiceFactory getInstance() {
		return instance;
	}
	
	
	public XMLService getService(ParserType type) throws XMLServiceException{
		
		//XMLService service;
		
		switch(type) {
		case SAX:
			return SaxXmlService.getInstance();
		case STAX:
			return StaxXmlService.getInstance();
		case DOM:
			return DomXmlService.getInstance();
		default:
			throw new XMLServiceException("There is not such type of parsing!(service)");

		}
	}

}
