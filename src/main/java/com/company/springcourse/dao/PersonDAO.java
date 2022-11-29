package com.company.springcourse.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.company.springcourse.models.Person;
@Component
public class PersonDAO {
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Person> index(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
		//or new MyRowMapper()
	}
	public Person show(int id) {
		return jdbcTemplate.query("select * from person where id=?",
		 new BeanPropertyRowMapper<>(Person.class),id).stream().findAny().orElse(null);
	}
	public void save(Person person) {
		jdbcTemplate.update("insert into person values(1,?,?,?)",person.getName(),person.getAge(),person.getEmail());
	}
	public void update (int id,Person updatedPerson) {
		jdbcTemplate.update("update person set name=?,age=?,email=? where id=?",updatedPerson.getName(),updatedPerson.getAge(),updatedPerson.getEmail(),id);
	}
	public void delete(int id) {
      jdbcTemplate.update("delete from person where id=?",id);
	}
}
