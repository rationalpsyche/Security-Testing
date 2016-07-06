package it.unitn.rationalpsyche.security.testing.teacher;

import it.unitn.rationalpsyche.security.testing.utilities.Database;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;
import org.junit.After;

public class ManageAssignment  extends it.unitn.rationalpsyche.security.testing.BaseTeacher {
	@Test
	public void varCoursename() {
		String injection = "' union select concat(coursename,' <a href=\"http://www.unitn.it\">Evil</a>') from courses where courseid = '1";
		
		this.selectClass();
		tester.clickLinkWithText("Assignments");
		tester.setWorkingForm("teacher");
		tester.setHiddenField("selectclass", injection);
		tester.clickLinkWithText("Assignments");
		//tester.assertMatch("ManageAssignments.php");
		tester.assertLinkNotPresentWithText("Evil");
	}
	
	@Test
	public void fieldSelectClass(){
		selectClass();
		navigateTo("Assignments","assignments");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage(){
		selectClass();
		navigateTo("Assignments","assignments");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2(){
		selectClass();
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		tester.setWorkingForm("teacher");
		tester.setHiddenField("page2", "2"+this.pattern1);
		Methods.newSubmitButton("//form[@name='teacher']",tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

	@Test
	public void onpage(){
		selectClass();
		navigateTo("Assignments","assignments");
		tester.setHiddenField("onpage",this.pattern1);
		tester.setWorkingForm("assignments");
        Methods.newSubmitButton("/html//form[@name=\"assignments\"]",tester);
        tester.submit();     
        tester.assertMatch("Manage Assignments");
        tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void assignmentTask() { // Stored XSS not found by pixy
		selectClass();
		navigateTo("Assignments","assignments");
		tester.clickButtonWithText("Add");
		tester.setWorkingForm("addassignment");
		tester.setTextField("title", "Foo");
		tester.setTextField("task", "<a href=\"http://unitn.it\">Evil Link</a>");
		tester.setTextField("total", "10");
		tester.setTextField("assigneddate", "1");
		tester.setTextField("duedate", "5");
		tester.clickButtonWithText("Add Assignment");
		
		tester.assertLinkNotPresentWithText("Evil Link");
	}
	

	@After
	public void Restore() {
		Integer status = Database.queryDB("DELETE from assignments WHERE title = 'Foo'");
		System.out.println("Status of restore assignments: "+status);
	}


}
