package spring.girish.ExceptionHandlingWithMapping.CustomValidatorAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{
/*	@Override
	public void initialize(IsValidHobby isValidHobby) {
		
	}
	@Override
	public boolean isValid(String hobby, ConstraintValidatorContext ctx) {

		if (hobby==null)return false;
		if(hobby.matches("Music|Football|Cricket|Hockey"))
			return true;
		else
			return false;
		
}*/
	private String listOfValidHobbies;
	
	@Override
	public void initialize(IsValidHobby isValidHobby) {
	this.listOfValidHobbies=isValidHobby.listOfValidHobbies();
	}
	
	@Override
	public boolean isValid(String hobby, ConstraintValidatorContext ctx) {

		if (hobby==null)return false;
		if(hobby.matches(listOfValidHobbies))
			return true;
		else
			return false;
		
}

}