package com.company.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.springcourse.dao.PersonDAO;
import com.company.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private PersonDAO personDAO;
	@Autowired
	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	@GetMapping()
	public String index(Model model) {
		model.addAttribute("list",personDAO.index());
		return "people/index";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id,Model model) {
		model.addAttribute("person",personDAO.show(id));
		return "people/show";
	}
	@GetMapping("/new")
	public String newPerson (Model model) {
		model.addAttribute("person", new Person());
		return "people/new";
	}
	@PostMapping()
	public  String create (@ModelAttribute("person") Person person) {
		personDAO.save(person);
		return "redirect:/people";
	}
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") int id,Model model) {
		model.addAttribute("person",personDAO.show(id));
		return "people/edit";
	}
	@PatchMapping("/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute("person") Person person) {
		personDAO.update(id,person);
		return "redirect:/people";
	}
	@DeleteMapping("/{id}")
	public String delete (@PathVariable("id")int id) {
		personDAO.delete(id);
		return "redirect:/people";
	}
	
}