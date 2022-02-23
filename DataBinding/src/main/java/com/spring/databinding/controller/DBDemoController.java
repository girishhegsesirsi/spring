package com.spring.databinding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.databinding.bean.Address;
import com.spring.databinding.bean.Emp;

@Controller
public class DBDemoController {
	
@RequestMapping("/empform")
public ModelAndView showform() {
	return new ModelAndView("empform");
}


@RequestMapping("/save")
public ModelAndView save(@ModelAttribute("Emp1")Emp emp) {
	System.out.println("Emp name:"+emp.getName()+"Emp ID:"+emp.getId()+"Emp Salary:"+emp.getSalary()+"Emp destination:"+emp.getDestination());
	return new ModelAndView("viewemp");
}

/*public ModelAndView viewemp() {
	List<Emp> list=new ArrayList<Emp>();
	//Address adr1= new Address("halkani","Sirsi","Karnataka");
	list.add(new Emp(253545,"Girish",55000,"infy",adr1));
	
	return new ModelAndView("viewemp","list",list);
}
*/
@ModelAttribute
public void getGlobal(Model model) {
	model.addAttribute("tittle", "Emp reg");
}
}
