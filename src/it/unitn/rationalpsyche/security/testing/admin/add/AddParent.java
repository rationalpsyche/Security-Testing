package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddParent extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Parents", "parents");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		
		tester.assertMatch("Add New Parent");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Parents", "parents");
		
		tester.setHiddenField("page2", "23"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='parents']", tester);
		tester.submit();
		tester.assertMatch("Add New Parent");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}

}