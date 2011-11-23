package localData;

import java.io.FileReader;

public class Config {

	public static String DBHost = "";
	public static String DBUsername = "";
	public static String DBport = "";
	public static String DBPassword = "";
	public static String DBName = "";
	public static String PASSWORD = "";
	
	public static void init() throws Exception {
		JSONObject json = new JSONObject(new JSONTokener(new FileReader("config.json")));
		JSONObject db = json.getJSONObject("db");
		DBHost = db.getString("host");
		DBUsername = db.getString("username");
		DBport = db.getString("port");
		DBPassword = db.getString("password");
		DBName = db.getString("name");
		
		PASSWORD = json.getString("adminPassword");

	}




}
