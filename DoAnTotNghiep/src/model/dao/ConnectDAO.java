package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectDAO{
	private Connection connect;
	private  Statement statement;
	
	public void openConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost;databaseName=DOAN";	 
			String user = "sa";
			String pass = "laducphuc";
			connect = DriverManager.getConnection(url, user, pass);
			statement = connect.createStatement();
			System.out.println("Kết nối thành công!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Kết nối thất bại 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Kết nối thất bại 2");
		}
	}
	
	public void closeConnection(){
		try {
			connect.close();
			System.out.println("Đóng kết nối thành công !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Đóng kết nối thất bại!");
		}
	}
	
	public Statement getStatement(){
		return this.statement;
	}
	public PreparedStatement getPreparedStatement(String sql){
		try {
			return connect.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Connection getConnect(){
		return this.connect;
	}
	public static void main(String []agrs){
		new ConnectDAO().openConnection();
	}
}
