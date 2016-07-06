package it.unitn.rationalpsyche.security.testing.parent;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ParentViewCourses extends it.unitn.rationalpsyche.security.testing.BaseParent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "5"+this.pattern1);
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Patrick Rossi's Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "5"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertMatch("Patrick Rossi's Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldStudent() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("student", this.pattern2);
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Patrick Rossi's Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
