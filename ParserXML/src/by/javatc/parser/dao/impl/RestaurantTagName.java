package by.javatc.parser.dao.impl;

public enum RestaurantTagName {

	PRICE,
	CATEGORY,
	INGREDIENTS,
	INGREDIENT,
	DISH,
	RESTAURANT;
	
	
	public static RestaurantTagName getElementTagName(String element) {
		switch (element) {
		case "dish":
			return DISH;
		case "price":
			return PRICE;
		case "category":
			return CATEGORY;
		case "ingredients":
			return INGREDIENTS;
		case "ingredient":
			return INGREDIENT;
		case "restaurant":
			return RESTAURANT;
		default:
			throw new EnumConstantNotPresentException(RestaurantTagName.class, element);
		}
	}
}
