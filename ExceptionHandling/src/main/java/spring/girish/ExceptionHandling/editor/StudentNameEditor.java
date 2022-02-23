package spring.girish.ExceptionHandling.editor;

import java.beans.PropertyEditorSupport;
/**Custom Property Editor*/
public class StudentNameEditor extends PropertyEditorSupport{
@Override
public void setAsText(String name)throws IllegalArgumentException{
	if (name.contains("Mr.") || name.contains("Ms.")) {
		setValue(name);
	}
	name="Mr." +name;
	setValue(name);
}
}
