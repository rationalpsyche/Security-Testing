package it.unitn.rationalpsyche.security.testing.admin.add;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class AddUser extends it.unitn.rationalpsyche.security.testing.BaseAdmin {

	@Test
	public void fieldPage() {
		this.navigateTo("Users", "users");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New User");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Users", "users");
		tester.setHiddenField("page2", "14"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"users\"]", tester);
		tester.submit();
		tester.assertMatch("Add New User");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
