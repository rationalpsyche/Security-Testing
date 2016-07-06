package it.unitn.rationalpsyche.security.testing.admin.report;

import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class DeficiencyReport extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Students", "students");
		tester.setTextField("page", "1"+this.pattern1);
		tester.selectOption("report", "Deficiency Report");
		tester.assertMatch("Deficiency Report");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2() {
		this.navigateTo("Students", "students");
		tester.setTextField("page2", "27"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"students\"]", tester);
		tester.submit();
		tester.assertMatch("Deficiency Report");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
