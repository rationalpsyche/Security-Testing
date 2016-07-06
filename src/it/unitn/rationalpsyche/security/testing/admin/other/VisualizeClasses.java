package it.unitn.rationalpsyche.security.testing.admin.other;

import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class VisualizeClasses extends it.unitn.rationalpsyche.security.testing.BaseAdmin  {

	@Test
	public void fieldPage() {
		tester.setWorkingForm("classes");
		tester.setTextField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Show in Grid");
		tester.assertMatch("School Class Schedule");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2() {
		tester.setWorkingForm("classes");
		tester.setTextField("page2", "25"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"classes\"]", tester);
		tester.submit();
		tester.assertMatch("School Class Schedule");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}
