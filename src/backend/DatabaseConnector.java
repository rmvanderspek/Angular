package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;


public class DatabaseConnector {
	
	String dbms = "sqlserver";
    String serverName = "jdbc:sqlserver://hanzeltog.database.windows.net:1433;database=testDataBase;user=hanzeltog@hanzeltog;password=!H4Nz3lT0@;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    Connection conn;
    Statement ST;
    ResultSet RS;
    
    public Connection getConnection() throws SQLException {

        if (conn == null) {
            Properties connectionProps = new Properties();
            connectionProps.put("user", "hanzeltog@hanzeltog");
            connectionProps.put("password", "!H4Nz3lT0@");

            conn = DriverManager.getConnection(serverName);

            System.out.println("Connected to database");
        }
        return conn;
    }
    
    public boolean addItem(String sender, String receiver, String subject, Date date){
    	PreparedStatement pstmt = null;
    	String updateString = "INSERT INTO Items VALUES (?,?,?,?);";
    	boolean succes = false;
    	
    	try {
    		pstmt = conn.prepareStatement(updateString);
    		DateFormat df = DateFormat.getInstance();
    		String dateString = df.format(date);
    		
    		pstmt.setString(1, sender);
    		pstmt.setString(2,  receiver);
    		pstmt.setString(3, subject);
    		pstmt.setString(4,  dateString);
    		
    		pstmt.executeUpdate();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    	
    }
    
}
