package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQL {
	private String URL = "jdbc:mysql://localhost:3306/bai2";
	private String userName = "root";
	private String password = "123456";
	//Hàm lấy kết nối csdl
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Lấy ra kết nối
			Connection conn = (Connection)DriverManager.getConnection(URL, userName, password);
			if(conn != null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("Fail to connect");
			}
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	
	public ResultSet getData(String sql) throws SQLException{
		Connection conn = getConnection();
		Statement sm = conn.createStatement();
		ResultSet resultSet = sm.executeQuery(sql);
		return resultSet;
	}
	
	//Hàm thực thi các lệnh như  Update  Create Drop Delete
	//Trả về số dòng bị ảnh hưởng (Rowaffect)
	public int executeSQL(String sql) throws SQLException {
		Connection conn = getConnection();
		Statement sm = conn.createStatement();
		int state = sm.executeUpdate(sql);
		return state;
	}
	
}
