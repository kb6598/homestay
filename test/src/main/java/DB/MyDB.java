package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB {

	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String url = "jdbc:mysql://localhost:3306/javadb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			String url = "jdbc:mysql://itbuddy.iptime.org:8233/capstone";
			String user = "capstone";
			String pwd = "capstone1234";

			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


	public static void main(String[] args) {
		Connection con = getCon();
		if (con != null){System.out.println("연결성공");}
		else{System.out.println("연결실패");}


	}
}