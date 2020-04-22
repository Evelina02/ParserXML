package by.javatc.parser.dao;

import by.javatc.parser.bean.ParserType;
import by.javatc.parser.dao.impl.dom.DomXmlDao;
import by.javatc.parser.dao.impl.sax.SaxXmlDao;
import by.javatc.parser.dao.impl.stax.StaxXmlDao;

public class XMLDAOFactory {

	private static final XMLDAOFactory instance = new XMLDAOFactory();

	public static XMLDAOFactory getInstance() {
		return instance;
	}
	
	
	public XMLDao getDAO(ParserType type) throws XMLDAOException{
		
		//XMLDao dao;
		
		switch(type) {
		case SAX:
			return SaxXmlDao.getInstance();
		case STAX:
			return StaxXmlDao.getInstance();
		case DOM:
			return DomXmlDao.getInstance();
		default:
			throw new XMLDAOException("There is not such type of parsing!");

		}
	}
	
}
