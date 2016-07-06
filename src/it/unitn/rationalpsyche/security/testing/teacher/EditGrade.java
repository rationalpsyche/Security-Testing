package it.unitn.rationalpsyche.security.testing.teacher;

import it.unitn.rationalpsyche.security.testing.BaseStudent;
import it.unitn.rationalpsyche.security.testing.utilities.Database;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.After;
import org.junit.Test;

public class EditGrade extends it.unitn.rationalpsyche.security.testing.BaseTeacher {

	@Test
	public void fieldAssignment(){
		selectClass();
		navigateTo2("Grades","grades");
		
		tester.getElementByXPath("//select/option[@value='1']").setAttribute("value",this.pattern4);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass(){
		selectClass();
		navigateTo2("Grades","grades");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage(){
		selectClass();
		navigateTo2("Grades","grades");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2(){
		selectClass();
		navigateTo2("Grades","grades");
		tester.setHiddenField("page2", "7"+this.pattern1);
		Methods.newSubmitButton("//form[@name='grades']",tester);
		tester.checkCheckbox("delete[]","1");
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void id() {
		selectClass();
		navigateTo2("Grades","grades");
		tester.getElementByXPath("//input[@type='checkbox' and @value='1']").setAttribute("value",this.pattern2);
		tester.checkCheckbox("delete[]");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void commentGrade() { // Stored XSS not found by pixy
		
		// from the teacher panel the stored XSS is injected
		selectClass();
		navigateTo2("Grades","grades");
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertMatch("Edit Grade");
		tester.setTextField("comment", "<a href=\"http://unitn.it\">Link to Malware</a>");
		tester.clickButtonWithText("Edit Grade");
		
		// from the student panel the XSS is displayed
		BaseStudent student = new BaseStudent();
		student.prepare();
		student.selectClass();
		student.tester.clickLinkWithText("Grades");
		student.tester.assertLinkNotPresentWithText("Link to Malware");
		
	}

	@After
	public void Restore() {
		Integer status = Database.queryDB("DELETE from grades WHERE comment LIKE '%Link to Malware%'");
		System.out.println("Status of restore grades: "+status);
	}
}
