package logic;
import java.sql.Connection;

public class Product {
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="price"
	 */
	private double price;
	
	private int nr;
	
	public Product(String name, String description, double price, int nr){
		this.name = name;
		this.description = description;
		this.price = price;
		this.nr = nr;
	}
	
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	private Product() { }

	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  the name to set
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return  the description
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description  the description to set
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return  the price
	 * @uml.property  name="price"
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price  the price to set
	 * @uml.property  name="price"
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public String getIdAsString() {
		return String.valueOf(id);
	}
	public int getId() {
		return id;
	}
	/**
	 * sets the id
	 * @param  id
	 * @uml.property  name="id"
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * returns a string representation of the product
	 */
	public String toString(){
		String result;
		result = getName() + ": " + getPrice() + " NOK";
		return result;
	}
	
	
}