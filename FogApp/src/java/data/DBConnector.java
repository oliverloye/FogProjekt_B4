package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class DBConnector {
	private Connection connection = null;
	
	//Constants
	private static final String IP	     = "localhost";
	private static final String PORT     = "3306";
	public static final String DATABASE  = "fog";
	private static final String USERNAME = "root"; 
	private static final String PASSWORD = "ninus224";	     	
	
	public DBConnector() throws Exception {
   		Class.forName("com.mysql.jdbc.Driver").newInstance();
   		String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
   		this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
	}
	
	public Connection getConnection() {
   		return this.connection;
	}
        
        

}
