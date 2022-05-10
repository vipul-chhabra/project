package office;

import java.io.Serializable;

public class Product implements Serializable {
/** product class
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private int quantity;
private String date ;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Product [name=" + name + ", quantity=" + quantity + ", date=" + date + "]";
}
public Product(String name, int quantity, String date) {
	super();
	this.name = name;
	this.quantity = quantity;
	this.date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
