package it.unitn.rationalpsyche.security.testing.student;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ViewGrades extends it.unitn.rationalpsyche.security.testing.BaseStudent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "4"+this.pattern1);
		tester.clickLinkWithExactText("Grades");
		tester.assertMatch("View Grades");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "3"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertMatch("View Grades");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("selectclass", "1"+this.pattern1);
		tester.clickLinkWithExactText("Grades");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
