package console_hospital_application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection 
{
	private static String url = "jdbc:mysql://localhost:3306/hospital_management";
	private static String mysqlUser = "root";
	private static String password = "Vignesh@2001";
    private static Connection conn ;   // object reference
	private GetConnection()
	{
		
	}

	public static Connection getConnectionInstance() throws SQLException
	{
		if(conn == null || conn.isClosed())
		{
			conn =  DriverManager.getConnection(url, mysqlUser, password);
		}
		return conn;
		
	}

}
