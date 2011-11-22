package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import localData.Config;


/** Klassen som setter opp koblingen til databasen
 *  Bruk getConnection() for å få en kobling til databasen
 */
public class DatabaseConnector{	

	public DatabaseConnector(){	}
	private static Connection con = null; // connection object
	private static Statement stmt = null; // statement object

	public static void initialize(){
		try {
			con = getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke laste inn databasen", "Database-error",  JOptionPane.ERROR_MESSAGE);
		}
		Address.setConnection(con);
	}
	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql:" + Config.DBHost + ":" + Config.DBport + "/" + Config.DBName;
		String user = Config.DBUsername;
		String password = Config.DBPassword;

		try{
			Class.forName("com.mysql.jdbc.Driver");     	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke laste inn sql driver", "Driver-error",  JOptionPane.ERROR_MESSAGE);

		}
		return DriverManager.getConnection(url, user, password);
	}
	public void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
			lgr.log(Level.WARNING, ex.getMessage(), ex);
		}
	}
	/**
	 * 
	 * @param phoneNumber
	 * @return	User fra database med requested phoneNumber
	 * @throws Exception
	 */
	public static User getUser(String phoneNumber) throws Exception{
		String sql = "SELECT name, phone, address_id, id FROM users WHERE phone='" + phoneNumber + "'";
		ResultSet getUser_rs = stmt.executeQuery(sql);
		if (getUser_rs.first() == false) {
			return null;
		}
		String name = getUser_rs.getString(1);
		String phone = getUser_rs.getString(2);
		String address_id = getUser_rs.getString(3);
		String id = getUser_rs.getString(4);
		getUser_rs.close();

		ResultSet getAddress_rs = stmt.executeQuery("SELECT street, houseNumber, zipcode, city, id FROM addresses WHERE id='"+address_id+"'");
		getAddress_rs.first();
		Address address = new Address(getAddress_rs.getInt(5), getAddress_rs.getString(1), Integer.parseInt(getAddress_rs.getString(2)), getAddress_rs.getString(3), getAddress_rs.getString(4));
		getAddress_rs.close();
		User user = new User(name, phone, address);
		user.setUserId(id);
		return user;
	}
	/** 
	 * @param Userid from database
	 * @return users name from database
	 * @throws Exception
	 */
	public static String getUser(int id) throws Exception{
		ResultSet getUser_rs = stmt.executeQuery("SELECT name FROM users WHERE id='" + id + "'");
		getUser_rs.first();
		String s = getUser_rs.getString(1);
		getUser_rs.close();
		return s;
	}
	/**
	 * user id, returns user
	 */
	public static String getPhoneByUserId(int id) throws Exception{
		ResultSet getUser_rs = stmt.executeQuery("SELECT phone FROM users WHERE id='" + id + "'");
		getUser_rs.first();
		String s = getUser_rs.getString(1);
		getUser_rs.close();
		return s;
	}

	/**
	 * 
	 * @return arraylist med alle users fra database
	 * @throws Exception
	 */
	public static DefaultListModel getUsers() throws Exception{
		ResultSet address_rs = stmt.executeQuery("SELECT id, street, houseNumber, zipcode, city FROM addresses");
		DefaultListModel users = new DefaultListModel();
		address_rs.first();
		ArrayList<Address> addresses = new ArrayList<Address>();    	
		do{
			int id = address_rs.getInt(1);
			String street = address_rs.getString(2);
			String houseNumber = address_rs.getString(3);
			String zipcode = address_rs.getString(4);
			String city = address_rs.getString(5);
			Address address = new Address(id, street, Integer.parseInt(houseNumber), zipcode, city);
			addresses.add(address);
		}while(address_rs.next());
		address_rs.close();
		ResultSet users_rs = stmt.executeQuery("SELECT name, phone, address_id, id FROM users order by name");
		users_rs.first();
		do{
			String name = users_rs.getString(1);
			String phone = users_rs.getString(2);
			String address_id = users_rs.getString(3);
			String id = users_rs.getString(4);
			//finding address from array with id equal to address_id
			for(int i = 0; i<addresses.size(); i++){
				if(addresses.get(i).getId() == Integer.parseInt(address_id)){
					User user = new User(name, phone, addresses.get(i));
					user.setUserId(id);
					users.addElement(user);
				}
			}
		}while(users_rs.next());
		address_rs.close();

		return users;
	}
	/**
	 * sets the delivery price
	 * @param s
	 */
	public static void setDeliveryPrice(String s){
		try {
			stmt.executeUpdate("UPDATE settings SET deliver_price ='" + Integer.parseInt(s) + "' WHERE id='1'");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greide ikke endre leveringspris");
			e.printStackTrace();
		}
	}
	/**
	 * sets the delivery pricelimit
	 * @param s
	 */
	public static void setPriceLimit(String s){
		try {
			stmt.executeUpdate("UPDATE settings SET deliver_limit ='" + Integer.parseInt(s) + "' WHERE id='1'");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greide ikke endre prisgrense for gratis levering");
		}
	}
	/**
	 * returnerer leveringspris
	 * @return
	 */
	public static double getDeliveryPrice(){
		try {
			con.setAutoCommit(true);
			ResultSet rs_del = stmt.executeQuery("SELECT deliver_price FROM settings WHERE id='1'");

			rs_del.first();
			con.setAutoCommit(false);
			return Double.parseDouble(rs_del.getString(1));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,	"Greide ikke hente leveringspris fra database");
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * returnerer prisgrense for gratis levering
	 * @return
	 */
	public static double getPriceLimit(){
		try {
			ResultSet rs_del = stmt.executeQuery("SELECT deliver_limit FROM settings WHERE id='1'");
			rs_del.first();
			return Double.parseDouble(rs_del.getString(1)); 

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,	"Greide ikke hente prisgrense fra database");
		}
		return -1;
	}
	/**
	 * 
	 * @param id
	 * @return productet med angitt id i databasen
	 * @throws Exception
	 */
	public static Product getProduct(String id) throws Exception{
		switch(id.charAt(0)){
		case 'o': id = "10"; break;
		case 'n': id = "11"; break;
		case 'i': id = "12"; break;
		case 'e': id = "13"; break;
		case 'q': id = "14"; break;
		case 'a': id = "15"; break;
		}
		ResultSet getP_rs = stmt.executeQuery("SELECT name, description, price FROM products WHERE id='"+id+"'");
		if(getP_rs.first() == false){
			return null;
		}
		String name = getP_rs.getString(1);
		String description = getP_rs.getString(2);
		String price = getP_rs.getString(3);
		Product p = new Product(name, description, Double.parseDouble(price));
		return p;
	}
	/**
	 * 
	 * @return alle produkter fra databasen
	 * @throws Exception
	 */
	public static DefaultListModel getProducts() throws Exception{
		DefaultListModel products = new DefaultListModel();
		ResultSet products_rs = stmt.executeQuery("SELECT name, description, price, id FROM products");
		products_rs.first();
		do{
			String name = products_rs.getString(1);
			String description = products_rs.getString(2);
			String price = products_rs.getString(3);
			String id = products_rs.getString(4);
			Product p = new Product(name, description, Double.parseDouble(price));
			p.setId(id);
			products.addElement(p);
		}while(products_rs.next());
		products_rs.close();

		return products;
	}
	/** 
	 * Sets a new user
	 * @param user
	 * @throws Exception
	 */
	public static void newUser(User user)throws Exception{
		con.setAutoCommit(true);
		int houseNumber = user.getAddress().getHouseNumber();
		String street = user.getAddress().getStreet(), zipcode = user.getAddress().getZipcode(), city = user.getAddress().getCity();
		stmt.executeUpdate("INSERT into addresses SET street='"+ street + "', houseNumber='"+ houseNumber +"', houseLetter='a', zipcode='"+ zipcode +"', city='"+ city +"', country='NO'");
		ResultSet newUser_rs = stmt.executeQuery("SELECT MAX(id) FROM addresses");
		newUser_rs.first();
		String address_id = newUser_rs.getString(1);
		stmt.executeUpdate("INSERT into users SET name='" + user.getName() + "', phone='" + user.getPhone() + "', address_id='"+ address_id + "'");
		newUser_rs.close();
		con.setAutoCommit(false);
	}
	/**
	 * returns orders as a DefaultListModel
	 * @param action
	 * @return DefaultListModel
	 * @throws Exception
	 */
	public static DefaultListModel getOrders(String action) throws Exception{
		String sql = "SELECT user_id, ordered, due, delivered, id, products, comment FROM orders WHERE ";
		if (action.equals("due")) {
			sql += "due IS NULL ORDER BY ordered";
		} else if(action.equals("deliver")) {
			sql += "due IS NOT NULL AND delivered IS NULL ORDER BY due";
		} else if(action.equals("delivered")) {
			sql += "delivered IS NOT NULL ORDER BY delivered";
		} else {
			throw new Exception("Action must be one of due, deliver or delivered.");
		}

		ResultSet orders_rs = stmt.executeQuery(sql);
		DefaultListModel orders = new DefaultListModel();
		if(orders_rs.first() == false){
			return orders;
		}
		do{
			String user_id = orders_rs.getString(1);
			String ordered = orders_rs.getString(2);
			String due = orders_rs.getString(3);
			String delivered = orders_rs.getString(4);
			String id = orders_rs.getString(5);
			String products = orders_rs.getString(6);
			String comment = orders_rs.getString(7);
			Order o =  new Order(user_id);
			o.createFoodList(products);
			o.setId(id);
			o.setDue(due);
			o.setDelivered(delivered);
			o.setKommentar(comment);
			orders.addElement(o);
		}while(orders_rs.next());
		orders_rs.close();
		return orders;
	}
	/**
	 * Sets a new order
	 * @param order
	 */
	public static void newOrder(Order order){
		try{
			stmt.executeUpdate("INSERT INTO orders SET user_id = '" + order.getUserId() + "', due = NULL, delivered = NULL, products = '" + order.getProducts() + "', comment='" + order.getKommentar() + "', levering='" + order.getLevering() + "', kort='" + order.getKort() + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke lagre ny bestilling i databasen", "Error",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * sets a new product
	 * @param product
	 */
	public static void newProduct(Product product){
		try{
			con.setAutoCommit(true);
			ResultSet newProduct_rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
			newProduct_rs.first();
			int id = Integer.parseInt(newProduct_rs.getString(1)) + 1;
			stmt.executeUpdate("INSERT INTO products VALUES (" + id + ", '" + product.getName() + "', '" + product.getDescription() + "', '" + product.getPrice() + "')");
			con.setAutoCommit(false);
			newProduct_rs.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke legge til nytt produkt i databasen", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * delets user
	 * @param user
	 */
	public static void deleteUser(User user){
		try{
			ResultSet deleteUser_rs = stmt.executeQuery("SELECT id, address_id from users WHERE name='" + user.getName() + "' AND phone='" + user.getPhone() + "'");
			deleteUser_rs.first();
			String id = deleteUser_rs.getString(1);
			String address_id = deleteUser_rs.getString(2);
			con.setAutoCommit(true);
			stmt.executeUpdate("DELETE from users WHERE id='" + id + "'");
			stmt.executeUpdate("DELETE from addresses WHERE id='" + address_id + "'");
			con.setAutoCommit(false);
			deleteUser_rs.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke slette kunde fra databasen", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * delets product
	 * @param product
	 */
	public static void deleteProduct(Product product){
		try{
			ResultSet deleteProduct_rs = stmt.executeQuery("SELECT id from products WHERE name='" + product.getName() + "' AND description='" + product.getDescription() + "' AND price='" + product.getPrice() + "'");
			deleteProduct_rs.first();
			int id = Integer.parseInt(deleteProduct_rs.getString(1));
			con.setAutoCommit(true);
			stmt.executeUpdate("DELETE from products WHERE id='" + id + "'");
			con.setAutoCommit(false);
			deleteProduct_rs.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke slette produkt fra databasen", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * delets order
	 * @param order
	 */
	public static void deleteOrder(Order order){
		try{
			con.setAutoCommit(true);
			stmt.executeUpdate("DELETE from orders WHERE id='" + order.getId() + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke slette bestilling fra databasen", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Updates a user
	 * @param oldUser
	 * @param newUser
	 */
	public static void edit(User oldUser, User newUser){
		try{
			String address_id, id;
			ResultSet edit_rs = stmt.executeQuery("SELECT address_id FROM users WHERE name='" + oldUser.getName() + "' AND phone='" + oldUser.getPhone() + "'");
			edit_rs.first();
			address_id = edit_rs.getString(1);
			edit_rs = stmt.executeQuery("SELECT id FROM users WHERE name='" + oldUser.getName() + "'AND phone ='" + oldUser.getPhone() + "'");
			edit_rs.first();
			id = edit_rs.getString(1);
			edit_rs.close();
			con.setAutoCommit(true);
			//oppdaterer addressen til address_id
			stmt.executeUpdate("UPDATE addresses SET street='" + newUser.getAddress().getStreet() + "', houseNumber='" + newUser.getAddress().getHouseNumber() + "', zipcode='" + newUser.getAddress().getZipcode() + "', city='" + newUser.getAddress().getCity() + "' WHERE id='" + address_id + "'");
			//Oppdaterer user
			stmt.executeUpdate("UPDATE users SET name='" + newUser.getName() + "', phone='" + newUser.getPhone() + "' WHERE id='" + id + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke endre kundeinformasjon", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * updates a product
	 * @param oldProduct
	 * @param newProduct
	 */
	public static void edit(Product oldProduct, Product newProduct){
		try{
			ResultSet edit = stmt.executeQuery("SELECT id from products WHERE name='" + oldProduct.getName() + "' AND description='" + oldProduct.getDescription() + "' AND price='" + oldProduct.getPrice() + "'");
			edit.first();
			String id = edit.getString(1);
			edit.close();
			con.setAutoCommit(true);
			stmt.executeUpdate("UPDATE products SET name='" + newProduct.getName() + "', description='" + newProduct.getDescription() + "', price='" + newProduct.getPrice() + "' WHERE id='" + id  + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Klarte ikke endre produktet", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * edits order
	 * @param id
	 */
	public static void edit(String id){
		try{
			con.setAutoCommit(true);
			stmt.executeUpdate("UPDATE orders SET due=now() WHERE id='" + id + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Bestillingen ble ikke satt til ferdig", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * sets an order as delivered
	 * @param order
	 */
	public static void delivered(Order o){
		try{
			con.setAutoCommit(true);
			stmt.executeUpdate("UPDATE orders SET delivered=now() WHERE id='" + o.getId() + "'");
			con.setAutoCommit(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * sets an order as not finished
	 * @param id
	 */
	public static void notFinished(String a){
		try {
			con.setAutoCommit(true);
			stmt.executeUpdate("UPDATE orders SET due = NULL WHERE id='" + a + "'");
			con.setAutoCommit(false);
		} catch (Exception e) {;
		JOptionPane.showMessageDialog(null, "Bestillingen ble ikke satt til 'ikke ferdig'", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * returns address to a user
	 * @param user_id
	 * @return
	 */
	public static Address getAddressFromUser(int user_id) {
		try {
			String sql = "SELECT a.id, a.street, a.houseNumber, a.zipcode, a.city FROM users AS u, addresses AS a WHERE u.address_id = a.id AND u.id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();
			rs.first();
			Address ad = new Address(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			rs.close();
			return ad;
		} catch(Exception e) {
			//			e.printStackTrace();
		}
		return null;
	}
	/**
	 * returns order
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Order getOrder(String s) throws Exception{
		if(s.length() <= 0){
			JOptionPane.showMessageDialog(null, "Ugyldig bestilling", "SQL-feil",  JOptionPane.ERROR_MESSAGE);
		}
		String stringID = "";
		boolean b = true;
		for(int i = 0; i<s.length(); i++){
			if((int)s.charAt(i) == 32){
				b = false;
			}
			if(b){
				stringID += s.charAt(i);				
			}
		}
		int id = Integer.parseInt(stringID);
		ResultSet getOrderRs = stmt.executeQuery("SELECT id, user_id, ordered, due, delivered, products, comment, levering, kort FROM orders WHERE id ='" + id + "'");
		getOrderRs.first();
		String i = getOrderRs.getString(1);
		String userID = getOrderRs.getString(2);
		String ordered = getOrderRs.getString(3);
		String due = getOrderRs.getString(4);
		String delivered = getOrderRs.getString(5);
		String products = getOrderRs.getString(6);
		String comment = getOrderRs.getString(7);
		int levering = getOrderRs.getInt(8);
		int kort = getOrderRs.getInt(9);
		Order o = new Order(userID);
		o.setDue(due);
		o.setId(i);
		o.setDelivered(delivered);
		o.createFoodList(products);
		o.setKommentar(comment);
		o.setLevering(levering);
		o.setKort(kort);
		return o;
	}
}
