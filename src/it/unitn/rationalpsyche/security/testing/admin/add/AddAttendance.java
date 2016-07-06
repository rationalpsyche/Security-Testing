package it.unitn.rationalpsyche.security.testing.admin.add;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class AddAttendance extends it.unitn.rationalpsyche.security.testing.BaseAdmin {

	@Test
	public void fieldSemester() {		
		tester.clickLinkWithText("Attendance");
		tester.assertMatch("Tardy");
		
		tester.setWorkingForm("registration");
		tester.getElementByXPath("//form[@name='registration']/select[@name='semester']/option[@value=1]").setAttribute("value","1"+this.pattern1);
		
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Attendance Record");
		tester.assertLinkNotPresentWithText(this.assertInjection);
			
	}
	
	@Test
	public void fieldStudent() {
		tester.clickLinkWithText("Attendance");
		tester.assertMatch("Tardy");
		
		tester.setWorkingForm("registration");
		tester.getElementByXPath("//form[@name='registration']/select[@name='student']/option[@value=1]").setAttribute("value","1"+this.pattern1);
		
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Attendance Record");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		tester.clickLinkWithText("Attendance");
		tester.assertMatch("Tardy");
		
		tester.setWorkingForm("registration");
		tester.setTextField("page2", "30"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"registration\"]", tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void fieldPage() {
		tester.clickLinkWithText("Attendance");
		tester.assertMatch("Tardy");
        tester.setWorkingForm("registration");
        tester.setHiddenField("page","1"+this.pattern1);
        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Attendance Record");
        tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
