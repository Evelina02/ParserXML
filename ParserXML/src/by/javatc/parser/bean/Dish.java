package by.javatc.parser.bean;

import java.io.Serializable;
import java.util.Set;

public class Dish implements Serializable {

    private static final long serialVersionUID = 12L;

	private String id;
	private String name;
	private double price;
	private Category category;
	private String picture;
	private String amount;
	
	private Set<String> ingredients;
	
	public Dish() {}

	public Dish(String id, String name, double price, Category category, String picture, String amount,
			Set<String> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.picture = picture;
		this.amount = amount;
		this.ingredients = ingredients;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Set<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", picture="
				+ picture + ", amount=" + amount + ", ingredients=" + ingredients + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (category != other.category)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	
}
