package spring.girish.ExceptionHandling.bean;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import spring.girish.ExceptionHandling.CustomValidatorAnnotation.IsValidHobby;

public class Student {

	//@NotNull
	@Max(253545)
	private int id;
	//@Size (min=6, max=15, message="Please enter the name field between {min} and {max} characters")
	@Pattern(regexp="[^0-9]*")
	private String name;
	//@Size (min=2, max=10) @IsValidHobby
	@Size (min=2, max=10) @IsValidHobby(listOfValidHobbies="Music|Football|Cricket|Hockey")
	private String hobby;
	private long mobile;
	@Past
	private Date DOB;
	private ArrayList<String> skills;
	private Address studentAddress;
	/*public Student(int id, String name, String hobby, long mobile, Date dOB, ArrayList skills, Address studentAddress) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
		this.mobile = mobile;
		DOB = dOB;
		this.skills = skills;
		this.studentAddress = studentAddress;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

}
