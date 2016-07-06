package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddTeacher extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Teachers", "teachers");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		
		tester.assertMatch("Add New Teacher");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Teachers", "teachers");
		
		tester.setHiddenField("page2", "16"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='teachers']", tester);
		tester.submit();
		tester.assertMatch("Add New Teacher");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}

}
