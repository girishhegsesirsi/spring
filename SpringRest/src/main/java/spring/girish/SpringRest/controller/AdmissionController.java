package spring.girish.SpringRest.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.girish.SpringRest.bean.Student;

@RestController
public class AdmissionController {
	
//@Responsebody is not required if RestController annotation is used	
//@ResponseBody
@RequestMapping("/getStudent")
public ArrayList getStudents() {
	System.out.println("inside the getStudent()");
Student s1 = new Student();
s1.setName("girish");
s1.setId(123);
s1.setMobile(70223);
Student s2 = new Student();
s2.setName("Harish");
s2.setId(124);
s2.setMobile(70223);

ArrayList stList = new ArrayList();
stList.add(s1);
stList.add(s2);
System.out.println("exiting the getStudent()");
return stList;
}
@RequestMapping(value="/getStudent/{name}",method=RequestMethod.GET)
public ArrayList getStudent(@PathVariable String name) {
	System.out.println("inside the getStudent() for the Student :"+name);
Student s1 = new Student();
s1.setName("girish");
s1.setId(123);
s1.setMobile(70223);


ArrayList stList = new ArrayList();
stList.add(s1);

System.out.println("exiting the getStudent()");
return stList;
}
}
