package it.unitn.rationalpsyche.security.testing.teacher;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class EditAssignment extends it.unitn.rationalpsyche.security.testing.BaseTeacher {

	@Test
	public void fieldSelectClass(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.setHiddenField("page2", "5"+this.pattern1);
		Methods.newSubmitButton("//form[@name='assignments']",tester);
		tester.checkCheckbox("delete[]","1");
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void id() {
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("assignments");
		tester.getElementByXPath("//input[@type='checkbox' and @value='1']").setAttribute("value",this.pattern2);
		tester.checkCheckbox("delete[]");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
}
