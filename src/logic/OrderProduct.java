package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProduct {
	private int id;
	private int product_id;
	private int order_id;
	private int count;

	public OrderProduct(int id, int product_id, int order_id, int count) {
		this.id = id;
		this.product_id = product_id;
		this.order_id = order_id;
		this.count = count;
	}
	public OrderProduct(int product_id, int order_id, int count) {
		this.product_id = product_id;
		this.order_id = order_id;
		this.count = count;
	}
	
	public OrderProduct(ResultSet rs) throws SQLException {
		this.id = rs.getInt(1);
		this.product_id = rs.getInt(2);
		this.order_id = rs.getInt(3);
		this.count = rs.getInt(4);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return product_id;
	}
	public Product getProduct() throws Exception {
		return DatabaseConnector.getProduct(product_id);
	}
	public String getName() throws Exception {
		return getProduct().getName();
	}
	public void setProductId(int product_id) {
		this.product_id = product_id;
	}
	public int getOrderId() {
		return order_id;
	}
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
