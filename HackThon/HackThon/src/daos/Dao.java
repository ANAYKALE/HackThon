package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Utils.DbUtils;

public abstract class Dao implements AutoCloseable{
	protected Connection con;
	
	public Dao()throws Exception
	{
		con=DbUtils.getConnection();
	}
	
	public void close() throws Exception{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
