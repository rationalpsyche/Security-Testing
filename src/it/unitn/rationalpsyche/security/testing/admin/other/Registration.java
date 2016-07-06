package it.unitn.rationalpsyche.security.testing.admin.other;

import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class Registration extends it.unitn.rationalpsyche.security.testing.BaseAdmin  {

	@Test
	public void fieldPage() {
		tester.setWorkingForm("admin");
		tester.setTextField("page", "1"+this.pattern1);
		tester.clickLinkWithText("Registration");
		tester.assertMatch("Registration");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2() {
		tester.setWorkingForm("admin");
		tester.setTextField("page2", "26"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"admin\"]", tester);
		tester.submit();
		tester.assertMatch("Registration");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}
