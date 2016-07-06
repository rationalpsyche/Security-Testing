package it.unitn.rationalpsyche.security.testing.student;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ViewAssignment extends it.unitn.rationalpsyche.security.testing.BaseStudent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "5"+this.pattern1);
		tester.clickLinkWithExactText("Assignments");
		tester.assertMatch("View Assignments");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "2"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertMatch("View Assignments");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void onPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("View Assignments");
		tester.setTextField("onpage", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='assignments']", tester);
		tester.submit();
		tester.assertMatch("View Assignments");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("selectclass", "1"+this.pattern1);
		tester.clickLinkWithExactText("Assignments");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void varCoursename() {
		String injection = "' union select concat(coursename,' <a href=\"http://www.unitn.it\">Evil</a>') from courses where courseid = '1";
		
		this.selectClass();
		tester.clickLinkWithText("Assignments");
		tester.setWorkingForm("student");
		tester.setHiddenField("selectclass", injection);
		tester.clickLinkWithText("Assignments");
		//tester.assertMatch("ManageAssignments.php");
		tester.assertLinkNotPresentWithText("Evil");
	}

}
