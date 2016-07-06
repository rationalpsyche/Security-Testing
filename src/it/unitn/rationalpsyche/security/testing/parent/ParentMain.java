package it.unitn.rationalpsyche.security.testing.parent;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ParentMain extends it.unitn.rationalpsyche.security.testing.BaseParent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "4"+this.pattern1);
		tester.clickLinkWithExactText("Settings");
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("selectclass", "1"+this.pattern1);
		tester.clickLinkWithExactText("Settings");
		tester.assertMatch("ClassInfo.php: Unable to get the class information");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldStudent() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("student", "1"+this.pattern1);
		tester.clickLinkWithExactText("Settings");
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
