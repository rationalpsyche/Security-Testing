package it.unitn.rationalpsyche.security.testing.utilities;
import java.sql.*;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/schoolmate";
	
	static final String USER = "schoolmate";
	static final String PASS = "schoolmate";
	
	public static int queryDB(String sqlQuery) {
		Connection conn = null;
	   Statement stmt = null;
	   try{
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      stmt = conn.createStatement();
	      Integer rs = stmt.executeUpdate(sqlQuery);
	      
	      stmt.close();
	      conn.close();
	      
	      return rs;
	   }
	   catch(SQLException se){
		      se.printStackTrace();
	   }
	   catch(Exception e){
		      e.printStackTrace();
		   }
	   finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	   return 0;
		}
}


