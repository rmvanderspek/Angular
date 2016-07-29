package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


public class DatabaseConnector {
	
    private String serverName = "jdbc:sqlserver://hanzeltog.database.windows.net:1433;database=testDataBase;user=hanzeltog@hanzeltog;password=!H4Nz3lT0@;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private Connection conn;
    
    static {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	} catch(ClassNotFoundException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public DatabaseConnector() {
    	try {
    		conn = getConnection();
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		System.out.println("Connection is: " +conn);
    	}
    }
    
    private Connection getConnection() throws SQLException {

        if (conn == null) {
        	
            Properties connectionProps = new Properties();
            connectionProps.put("user", "hanzeltog@hanzeltog");
            connectionProps.put("password", "!H4Nz3lT0@");

            conn = DriverManager.getConnection(serverName);

            System.out.println("Connected to database");
        }
        return conn;
    }
    
    public boolean addItem(Item item){
    	
    	String sender = item.getSender();
		String receiver = item.getReceiver();
    	String subject = item.getSubject();
    	Date date = item.getDate();
    	String message = item.getMessage();
    	
    	PreparedStatement pstmt = null;
    	String updateString = "INSERT Items (sender, receiver, subject, date, message) VALUES (?,?,?,?,?);";
    	
    	try {
    		pstmt = conn.prepareStatement(updateString);
    		DateFormat df = DateFormat.getInstance();
    		String dateString = df.format(date);
    		
    		pstmt.setString(1, sender);
    		pstmt.setString(2, receiver);
    		pstmt.setString(3, subject);
    		pstmt.setString(4, dateString);
    		pstmt.setString(5, message);
    		
    		pstmt.executeUpdate();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    	
    }
    
    public ArrayList<Item> getItems(){
    	ArrayList<Item> items = new ArrayList<Item>();
    	
    	Statement stmt = null;
    	String query = "SELECT * FROM Items";
    	ResultSet rs = null;
    	
    	try {
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(query);
    		
    		while(rs.next()){
    			int id = rs.getInt(1);
    			String sender = rs.getString(2);
    			String receiver = rs.getString(3);
    			String subject = rs.getString(4);
    			String dateString = rs.getString(5);
    			DateFormat df = DateFormat.getInstance();
    			String message = rs.getString(6);
    			
    			Date date = df.parse(dateString);
    			
    			Item item = new Item(id, sender, receiver, subject, date, message);
    			items.add(item);
    		}
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	} catch (ParseException e) {
			e.printStackTrace();
		} 

    	return items;
    }
    
    public Item getItem(int id){
    	PreparedStatement pstmt = null;
    	String query = "SELECT * FROM Items WHERE ID = ?";
    	ResultSet rs = null;
    	
    	Item item = null;
    	
    	try {
    		
    		pstmt = conn.prepareStatement(query);
    		pstmt.setInt(1, id);
    		rs = pstmt.executeQuery();
    		
    		while (rs.next()){
    			String sender = rs.getString(2);
    			String receiver = rs.getString(3);
    			String subject = rs.getString(4);
    			String dateString = rs.getString(5);
    			DateFormat df = DateFormat.getInstance();
    			Date date = df.parse(dateString);
    			String message = rs.getString(6);
    			item = new Item(sender, receiver, subject, date, message);
    		}

    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
    }
    
    public static void main(String[] args) throws SQLException{
    }
    
}
