package by.javatc.parser.dao;

import java.util.List;
import by.javatc.parser.bean.Dish;

public interface XMLDao {

	List<Dish> parse(String resourceName) throws XMLDAOException;
}
