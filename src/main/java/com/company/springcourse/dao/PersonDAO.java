package com.company.springcourse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springcourse.models.Person;
@Component
public class PersonDAO {
	private List<Person> list;
	private static int PERSON_ID;
	{
		list = new ArrayList<>();
		list.add(new Person(++PERSON_ID, "Igor",18,"igorigor@mail.ru"));
		list.add(new Person(++PERSON_ID, "Sasha",24,"sashasasha12@mail.ru"));
		list.add(new Person(++PERSON_ID, "Bob",30,"bobbob111@gmail.com"));
		list.add(new Person(++PERSON_ID, "Tom",50,"tomtom444@gmail.com"));
	}
	public List<Person> index(){
		return list;
	}
	public Person show(int id) {
		return list.stream().filter(x->x.getId()==id).findAny().orElse(null);
	}
	public void save(Person person) {
		person.setId(++PERSON_ID);
		list.add(person);
	}
	public void update (int id,Person updatedPerson) {
		 Person personToBeUpdated = show(id);
		 personToBeUpdated.setName(updatedPerson.getName());
		 personToBeUpdated.setAge(updatedPerson.getAge());
		 personToBeUpdated.setEmail(updatedPerson.getEmail());
	}
	public void delete(int id) {
		list.removeIf(x->x.getId()==id);
	}
}
