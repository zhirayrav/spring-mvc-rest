package com.company.springcourse.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springcourse.models.Person;
@Component
public class PersonDAO {
	private static String url = "jdbc:postgresql://localhost:5432/first_db";
	private static String name = "postgres";
	private static String password = "postgres";
	private static Connection conn;
	static {
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, name, password);
		}catch(SQLException e)	{
			e.printStackTrace();
			}
	}
	
	public List<Person> index(){
		List<Person> list = new ArrayList<>();
		try {
		Statement statement = conn.createStatement();
		String SQL = "select * from person";
		ResultSet resultSet = statement.executeQuery(SQL);
		while(resultSet.next()) {
			Person person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setAge(resultSet.getInt("age"));
			person.setEmail(resultSet.getString("email"));
			list.add(person);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Person show(int id) {
		Person person = null;
		try {
			PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM person WHERE id=?");
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			resultSet.next();
			person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setAge(resultSet.getInt("age"));
			person.setEmail(resultSet.getString("email"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	public void save(Person person) {
		try{
			PreparedStatement preparedStatements = conn.prepareStatement("INSERT INTO person VALUES(1,?,?,?)");
			preparedStatements.setString(1, person.getName());
			preparedStatements.setInt(2, person.getAge());
			preparedStatements.setString(3, person.getEmail());
			preparedStatements.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void update (int id,Person updatedPerson) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("update person set name=?,age=?,email=? where id=?");
			preparedStatement.setString(1, updatedPerson.getName());
			preparedStatement.setInt(2, updatedPerson.getAge());
			preparedStatement.setString(3, updatedPerson.getEmail());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		
	}
	public void delete(int id) {
      try {
    	  PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM person WHERE id=?");
    	  preparedStatement.setInt(1, id);
    	  preparedStatement.executeUpdate();
      }catch (SQLException e) {
	     e.printStackTrace();
      	}
	}
}
