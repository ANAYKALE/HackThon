package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
public static  final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
public static  final String DB_URL="jdbc:mysql://localhost:3306/movie";
public static  final String DB_USER="root";
public static  final String DB_PASS="manager";

static {
	try {
		Class.forName(DB_DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static Connection getConnection() throws SQLException {
	Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	return con;
}
}
