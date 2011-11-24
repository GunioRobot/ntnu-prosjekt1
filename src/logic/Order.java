package logic;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import GUI.Start;

public class Order {
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="userId"
	 */
	private String userId;
	/**
	 * @uml.property  name="products"
	 */
	private DefaultListModel products;
	/**
	 * @uml.property  name="ordered"
	 */
	private String ordered;
	/**
	 * @uml.property  name="due"
	 */
	private String due = "";
	/**
	 * @uml.property  name="delivered"
	 */
	private String delivered;
	/**
	 * @uml.property  name="antall" multiplicity="(0 -1)" dimension="1"
	 */
	private int[] antall;
	/**
	 * @uml.property  name="kommentar"
	 */
	private String kommentar;
	/**
	 * @uml.property  name="produkt" multiplicity="(0 -1)" dimension="1"
	 */
	private String[] produkt;
	/**
	 * @uml.property  name="levering"
	 */
	private int levering;
	/**
	 * @uml.property  name="kort"
	 */
	private int kort;
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param ordered
	 * @param due
	 * @param delivered
	 */
	public Order(String userId){
		init();
		this.userId = userId;
	}
	public Order() {
		init();
		// TODO Auto-generated constructor stub
	}
	private void init() {
		this.products = new DefaultListModel();
	}
	/**
	 * sets levering
	 * @uml.property  name="levering"
	 */
	public void setLevering(int i){
		this.levering = i;
	}
	/**
	 * @return  levering true or false
	 * @uml.property  name="levering"
	 */
	public int getLevering(){
		return levering;
	}
	/**
	 * settter betaling med kort
	 * @param  boolean
	 * @uml.property  name="kort"
	 */
	public void setKort(int i){
		this.kort = i;
	}
	/**
	 * @return  kort
	 * @uml.property  name="kort"
	 */
	public int getKort(){
		return kort;
	}
	
	/**
	 * @return  the userId
	 * @uml.property  name="userId"
	 */
	public String getUserId() {
		return userId;			
	}
	/**
	 * @param userId  the userId to set
	 * @uml.property  name="userId"
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return  the products
	 * @uml.property  name="products"
	 */
	public DefaultListModel getProducts() {
		return this.products;
	}
	
	/**
	 * Lager en string som viser hvilke produkter og hvor mange som er bestyilt.
	 * @param  produkter, array som inneholder produktene som er bestilt.
	 * @throws Exception 
	 * @uml.property  name="products"
	 */
	
	//234 x Pizza nr.1
	public void setProducts(String[] produkter) throws Exception{
		String products = "";
		for(int i = 0; i<produkter.length; i++){
			boolean bol = true;
			for(int j = 0; j<produkter[i].length(); j++){
				if((int)produkter[i].charAt(j) == 32){
					bol = false;
				}
				if(bol){
					products += produkter[i].charAt(j);					
				}
			}
			products += ":";
			if((int)produkter[i].charAt(produkter[i].length()-1) > 57){
				products +=produkter[i].charAt(produkter[i].length()-3);
			}
			else
				products += produkter[i].charAt(produkter[i].length()-1);
			if(i+1 < produkter.length){
				products += "-";				
			}
		}
		createFoodList(products);
		
		DefaultListModel allProducts = DatabaseConnector.getProducts();
		
		this.products.clear();
		for (int i = 0; i < produkt.length; i++) {
			
			// Find product
			Product product = null;
			for(int j = 0; j < allProducts.size(); j++) {
				Product p = (Product) allProducts.getElementAt(j);
				if((int)produkt[i].charAt(produkt[i].length()-1) > 57){ // er en brus
					if (p.getName().charAt(p.getName().length()-3) == produkt[i].charAt(0)) {
						product = p;
						break;
					}
				}
				else { // er en pizza
					if (p.getNr() == Integer.parseInt(produkt[i])) {
						product = p;
						break;
					}
				}
				
			}
			
			if (product == null) {
				continue;
//				Start.exit("Det skjedde en feil ved parsing av produkter");
			}
			OrderProduct op = new OrderProduct(product.getId(), Integer.valueOf(this.getIdAsString()), antall[i]);
			this.products.addElement(op);
		}
	}
	/**
	 * Lager en liste over maten som er bestilt.
	 * @param s
	 */
	//43:6-3:2-5:1
	private void createFoodList(String s){
		int teller = 0;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == '-'){
				teller++;
			}
		}
		teller++;
		antall = new int[teller];
		produkt = new String[teller];
		teller = 0;
		String element = "";
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) != ':' && s.charAt(i) != '-'){
				element += s.charAt(i);
			}
			else if(s.charAt(i) == ':'){
				antall[teller] = Integer.parseInt(element);
				element = "";
			}
			else if(s.charAt(i) == '-'){
				produkt[teller] = element;
				element = "";
				teller++;
			}
		}
		produkt[teller] = element;
	}
	
	/**
	 * @param products the products to set
	 */
//	public void setProducts(String products) {
//		this.products = products;
//	}
	public int getId() {
		return id;
	}
	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public String getIdAsString() {
		return String.valueOf(id);
	}
	/**
	 * sets the order id.
	 * @param  a
	 * @uml.property  name="id"
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * Returns a string representation of the order.
	 */
	public String toString(){
		String s = getIdAsString() + " ";
		try {
			s += DatabaseConnector.getUser(Integer.parseInt(userId));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Klarte ikke lage toString i klasse Order", "toString",  JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}
	/**
	 * returns due
	 * @return
	 * @uml.property  name="due"
	 */
	public String getDue(){
		return this.due;
	}
	/**
	 * sets due
	 * @param  s
	 * @uml.property  name="due"
	 */
	public void setDue(String s){
		this.due = s;
	}
	/**
	 * sets delivered
	 * @param  s
	 * @uml.property  name="delivered"
	 */
	public void setDelivered(String s){
		this.delivered = s;
	}
	/**
	 * gets delivered
	 * @return
	 * @uml.property  name="delivered"
	 */
	public String getDelivered(){
		return this.delivered;
	}
	/**
	 * returns a istmodel containing the products in the order
	 * @return
	 * @throws Exception 
	 */
	public DefaultListModel getProductsStringAsDefaultListModel() throws Exception{
		DefaultListModel dlm = new DefaultListModel();
		for(int i = 0; i< products.size(); i++){
			OrderProduct po = (OrderProduct) products.getElementAt(i);
			dlm.add(i, po.getCount() + " x " + po.getName());
		}		
		return dlm;
	}
	/**
	 * Creates a string that represents the receipt.
	 * @return String
	 */
	public String getProductsString(){
		String temp = "<html><center>" + "Gruppe 10"  + "<br>" + "\tPizzeria\n" + "<br>Tlf: 13 37 13 37" + "</center>" + "<br>" + "---------------------------------------------------------" + "<br><br>";
		double sum = 0;
		double mva14 = 0, mva25 = 0;
		DecimalFormat d = new DecimalFormat("0.00");
		for(int i = 0; i< products.size(); i++){
			try {
				OrderProduct po = (OrderProduct) products.getElementAt(i);
				Product p = po.getProduct();
				String navn = p.getName();
				String pris = String.valueOf(p.getPrice()*po.getCount());
				temp += "<table width='100%'><tr><td align='left'>" + String.valueOf(po.getCount()) + " x " + navn + "</td>" + "<td align='right'>" + pris + ",-" + "</td>" + "</tr></table>" + "<br>";
				sum += Double.parseDouble(pris);
				mva14 += (Double.parseDouble(pris)/114)*14;
			} catch (Exception e) {
				if (Start.DEBUG) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Klarte ikke generere kvittering", "Bestilling",  JOptionPane.ERROR_MESSAGE);
			}
		}
		if(getLevering() == 1){
			if(sum > DatabaseConnector.getPriceLimit()){
				temp += "<table width='100%'><tr><td align='left'>" + "Levering</td>" + "<td align='right'>" + 0.0 + ",-" + "</td>" + "</tr></table>" + "<br>";
			}
			else{
				temp += "<table width='100%'><tr><td align='left'>" + "Levering</td>" + "<td align='right'>" + DatabaseConnector.getDeliveryPrice() + ",-" + "</td>" + "</tr></table>" + "<br>";
				sum += DatabaseConnector.getDeliveryPrice();
				mva25 += (DatabaseConnector.getDeliveryPrice()/125)*25;
			}
		}
		temp += "---------------------------------------------------------" + "<table width='100%'>" + "<tr>" + "<td align='left'>" + "Sum:" + "</td>" + "<td align='right'>" + sum + ",-" + "</td>" + "</tr>" + "</table>" + "<br><br>";
		temp += "<table width='100%'>" + "<tr>" + "<td align='left'>" + "Mva 14%:" + "</td>" +  "<td align='right'>" + d.format(mva14) + ",-" + "</td>" + "</tr>" + "</table>";
		temp += "<table width='100%'>" + "<tr>" + "<td align='left'>" + "Mva 25%:" + "</td>" +  "<td align='right'>" + d.format(mva25) + ",-" + "</td>" + "</tr>" + "</table>";
		temp += "<table width='100%'>" + "<tr>" + "<td align='right'>" + "-----------" + "--" + "</td>" + "</tr>" + "</table>";
		temp += "<table width='100%'>" + "<tr>" + "<td align='left'>" + "Sum mva:" + "</td>" +  "<td align='right'>" + d.format(mva14+mva25) + ",-" + "</td>" + "</tr>" + "</table>";
		
		return temp;
	}
	/**
	 * sets comment
	 * @param  kommentar
	 * @uml.property  name="kommentar"
	 */
	public void setKommentar(String kommentar){
		this.kommentar = kommentar;
	}
	/**
	 * gets comment
	 * @return
	 * @uml.property  name="kommentar"
	 */
	public String getKommentar(){
		return this.kommentar;
	}
	public void setProduct(OrderProduct op) {
		this.products.addElement(op);
	}
}