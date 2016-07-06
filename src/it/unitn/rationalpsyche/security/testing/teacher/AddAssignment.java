package it.unitn.rationalpsyche.security.testing.teacher;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class AddAssignment extends it.unitn.rationalpsyche.security.testing.BaseTeacher {

	@Test
	public void fieldSelectClass(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("page2", "4"+this.pattern1);
		Methods.newSubmitButton("//form[@name='assignments']",tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}
