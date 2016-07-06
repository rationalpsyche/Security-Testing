package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddStudent extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Students", "students");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		
		tester.assertMatch("Add New Student");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Students", "students");
		
		tester.setHiddenField("page2", "20"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='students']", tester);
		tester.submit();
		tester.assertMatch("Add New Student");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}

}