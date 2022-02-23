package com.spring.databinding.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.databinding.bean.Student;
import com.spring.databinding.editor.StudentNameEditor;

@Controller
public class AdmissionController {
	
	//PropertyEditors
	//used to edit/change the input data
	@InitBinder
	public void InitBinder(WebDataBinder wdb){
		wdb.setDisallowedFields(new String[] {"mobile"});
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		wdb.registerCustomEditor(Date.class, "DOB",new CustomDateEditor(sdf,false));
		wdb.registerCustomEditor(String.class, "name", new StudentNameEditor());
	} 
	@RequestMapping("/AdmissionForm")
	public ModelAndView getAdmissionForm() {
		ModelAndView model= new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "Please Enter the student information in the form");
		return model;
	}
	//BindingResult will hold all the errors
@RequestMapping(value="/SubmissionForm",method=RequestMethod.POST)
public ModelAndView processSubmittedForm(@Valid @ModelAttribute("student1") Student student, BindingResult result) {
	if(result.hasErrors()) {
		ModelAndView model =new ModelAndView("AdmissionForm");
		return model;	
	}
	ModelAndView model =new ModelAndView("StudentDetails");
	return model;
}

//Spring Framework will run this method before any other method
@ModelAttribute
public void defaultMessage(Model model) {
	model.addAttribute("defaultMessage","Please find the student information below : ");
}
}
