package it.unitn.rationalpsyche.security.testing.admin.other;

import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class VisualizeRegistration extends it.unitn.rationalpsyche.security.testing.BaseAdmin  {

	@Test
	public void fieldPage() {
		navigateTo2("Registration","registration");
		tester.setTextField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Show in Grid");
		tester.assertMatch("Patrick Rossi's Schedule");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2() {
		navigateTo2("Registration","registration");
		tester.setTextField("page2", "29"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"registration\"]", tester);
		tester.submit();
		tester.assertMatch("Patrick Rossi's Schedule");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}
