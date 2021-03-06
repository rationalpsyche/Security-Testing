package it.unitn.rationalpsyche.security.testing.student;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class StudentViewCourses extends it.unitn.rationalpsyche.security.testing.BaseStudent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "4"+this.pattern1);
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Patrick Rossi's Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "0"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertMatch("Patrick Rossi's Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
}
