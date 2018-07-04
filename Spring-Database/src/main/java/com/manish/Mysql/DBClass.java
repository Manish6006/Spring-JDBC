package com.manish.Mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBClass {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		insertEmployee();
		displayEmployees();
	}
	
	private static void displayEmployees() throws SQLException  {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop?autoReconnect=true&useSSL=false", "root", "helloworld");
				Statement statement = connection.createStatement();){
		
		ResultSet resultSet = statement.executeQuery("select * from employees");
		while ( resultSet.next()) {
			int empId = resultSet.getInt(1);
			String firstName = resultSet.getString(2);
			String lastName = resultSet.getString(3);
			Date dateOfJoining = resultSet.getDate(4);
			System.out.println(" EmpId: "+empId+" firstName: "+firstName+", lastName: "+lastName+", dateOfJoining: "+dateOfJoining);
		}
		}catch(Exception e) {
			System.out.println("Exception while connecting to the database.");
			e.printStackTrace();
		}
	}

	public static void insertEmployee() throws SQLException  {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop?autoReconnect=true&useSSL=false", "root", "helloworld");
				Statement statement = connection.createStatement();){
		
		boolean flag = statement.execute("insert into employees (EmpId,firstName, lastName, dateOfJoining) values (123,'Pawan', 'Krishna', '1983-04-04')");
		System.out.println("Employee record was inserted successfully : "+flag);
		}catch(Exception e) {
			System.out.println("Exception while connecting to the database.");
			e.printStackTrace();
		}
	}
}
