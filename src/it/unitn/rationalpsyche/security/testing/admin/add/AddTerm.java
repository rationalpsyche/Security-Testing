package it.unitn.rationalpsyche.security.testing.admin.add;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class AddTerm  extends it.unitn.rationalpsyche.security.testing.BaseAdmin {

	@Test
	public void fieldPage() {
		this.navigateTo("Terms", "terms");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Term");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Terms", "terms");
		tester.setHiddenField("page2", "8"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"terms\"]", tester);
		tester.submit();
		tester.assertMatch("Add New Term");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
