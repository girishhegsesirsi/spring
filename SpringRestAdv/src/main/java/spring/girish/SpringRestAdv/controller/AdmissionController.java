package spring.girish.SpringRestAdv.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.girish.SpringRestAdv.bean.Student;

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
@RequestMapping(value="/getStudent/{name}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
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
@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public Boolean updateStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());

System.out.println("exiting the getStudent()");
return true;
}
//PUT method simulation
/*@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public Boolean putStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());

System.out.println("exiting the getStudent()");
return true;
}*/

//ResponseEntity with no return value, it sends only the status
/*@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> putStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());

System.out.println("exiting the getStudent()");
return new ResponseEntity<Void>(HttpStatus.OK);	
}*/

//ResponseEntity with boolean return value
/*@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Boolean> putStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());

System.out.println("exiting the getStudent()");
return new ResponseEntity<Boolean>(true,HttpStatus.OK);	
}*/

//with HttpHeaders
@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Boolean> putStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.add("Key1", "Value1");
httpHeaders.add("Key2", "Value2");
System.out.println("exiting the getStudent()");
return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK);	
}

//with HttpHeaders and returns newly added student URI
@RequestMapping(value="/returnUri/{name}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Boolean> returnUri(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.add("Location", 
		ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{name}")
		.buildAndExpand(student.getName()).toUri().toString());
httpHeaders.add("Key2", "Value2");
System.out.println("exiting the getStudent()");
return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK);	
}
//http delete method simulation
@RequestMapping(value="/updateStudent/{name}",method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Boolean> deleteStudent(@PathVariable String name,@RequestBody Student student) {
	System.out.println("inside the updateStudent() for the Student :"+name);
	System.out.println("inside the updateStudent() for the student :"+student.getName());

System.out.println("deleting the getStudent()");
return new ResponseEntity<Boolean>(true,HttpStatus.OK);	
}
}
