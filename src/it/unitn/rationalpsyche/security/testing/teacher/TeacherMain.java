package it.unitn.rationalpsyche.security.testing.teacher;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class TeacherMain extends it.unitn.rationalpsyche.security.testing.BaseTeacher {
	@Test
	public void fieldPage(){
		selectClass();
		tester.setWorkingForm("teacher");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.clickLinkWithText("Settings");
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2(){
		selectClass();
		tester.setWorkingForm("teacher");
		tester.setHiddenField("page2", "1"+this.pattern1);
		Methods.newSubmitButton("//form[@name='teacher']",tester);
		tester.submit();
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass(){
		selectClass();
		tester.setWorkingForm("teacher");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.clickLinkWithText("Settings");
		tester.assertMatch("ClassInfo.php: Unable to get the class information");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
