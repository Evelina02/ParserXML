package by.javatc.parser.service;

import java.util.List;
import by.javatc.parser.bean.Dish;

public interface XMLService {

	List<Dish> parse(String resourceName) throws XMLServiceException;
	
}
