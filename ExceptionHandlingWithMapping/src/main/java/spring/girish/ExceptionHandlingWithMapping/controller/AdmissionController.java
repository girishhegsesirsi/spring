package spring.girish.ExceptionHandlingWithMapping.controller;

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
import org.springframework.web.servlet.ModelAndView;

import spring.girish.ExceptionHandlingWithMapping.bean.Student;
import spring.girish.ExceptionHandlingWithMapping.editor.StudentNameEditor;

@Controller
public class AdmissionController {
	
	//PropertyEditors
	@InitBinder
	public void InitBinder(WebDataBinder wdb){
		//wdb.setDisallowedFields(new String[] {"mobile"});
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
		wdb.registerCustomEditor(Date.class, "DOB",new CustomDateEditor(sdf,false));
		wdb.registerCustomEditor(String.class, "name", new StudentNameEditor());
	}
	@RequestMapping("/AdmissionForm")
	public ModelAndView getAdmissionForm() throws Exception {
		
		String exceptionOccured= "NULL_POINTER";
		
		if (exceptionOccured=="NULL_POINTER") {
			throw new ArithmeticException();
		}
		
		ModelAndView model= new ModelAndView("AdmissionForm");
		model.addObject("headerMessage", "Please Enter the student information in the form");
		return model;
	}
	
	//all Exception handler methods can be defined in a separate class with @ControllerAdvice annotation
	/*@ExceptionHandler(value=NullPointerException.class)	
	public String handleNPE(Exception e) {
		System.out.println("Null pointer Exception occured");
		return "NullPointerException";
	}
	@ExceptionHandler(Exception.class)	
	public String handleGenericException(Exception e) {
		System.out.println("Exception occured");
		return "Exception";
	}*/
	
@RequestMapping("/SubmissionForm")
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
