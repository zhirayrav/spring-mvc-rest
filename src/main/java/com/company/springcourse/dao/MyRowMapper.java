package com.company.springcourse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.springcourse.models.Person;

public class MyRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setAge(rs.getInt("age"));
		person.setEmail(rs.getString("email"));
		person.setAddress(rs.getString("address"));
		return person;
	}

}
