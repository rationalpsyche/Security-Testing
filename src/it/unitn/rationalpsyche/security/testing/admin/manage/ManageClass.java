package it.unitn.rationalpsyche.security.testing.admin.manage;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ManageClass extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickLinkWithText("Class");
		tester.assertMatch("Manage Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page2", "0"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"admin\"]", tester);
		tester.submit();
		tester.assertMatch("Manage Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void onPage() {
		this.navigateTo("Class","classes");
		tester.setHiddenField("onpage", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='classes']", tester);
		tester.submit();
		tester.assertMatch("Manage Classes");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
}

