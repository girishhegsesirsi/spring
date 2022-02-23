package spring.girish.RequestParam.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@RequestMapping("/empform")
	ModelAndView empForm() {
		ModelAndView model=new ModelAndView("empform");
		return model;
	}
	
	@RequestMapping("/processForm")
	ModelAndView processEmp(@RequestParam ("id") int empId,@RequestParam ("name") String empName,
			@RequestParam ("hobby") String empHobby,@RequestParam ("DOB") Date empDOB) {
/*		if (result.hasErrors()) {
			ModelAndView model=new ModelAndView("empform");
			return model;
		}
		*/
		ModelAndView model=new ModelAndView("EmpDetails");
		model.addObject("EmployeeID", empId);
		model.addObject("EmployeeName", empName);
		model.addObject("EmployeeHobby", empHobby);
		model.addObject("EmployeeDOB", empDOB);
		return model;
	}
	
	@RequestMapping("/processFormMap")
	ModelAndView processEmpMap(@RequestParam Map<String,String> paramMap) {
/*		if (result.hasErrors()) {
			ModelAndView model=new ModelAndView("empform");
			return model;
		}
		*/
		Date empDOB=null;
		ModelAndView model=new ModelAndView("EmpDetails");
		int empId =Integer.parseInt(paramMap.get("id"));
		String empName= paramMap.get("name");
		String empHobby= paramMap.get("hobby");
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		 empDOB= sdf.parse(paramMap.get("DOB"));
		}
		catch (Exception e) {
			System.out.println("exception occurred : " +e.getMessage());
		}
		model.addObject("EmployeeID", empId);
		model.addObject("EmployeeName", empName);
		model.addObject("EmployeeHobby", empHobby);
		model.addObject("EmployeeDOB", empDOB);
		return model;
	}


}
	