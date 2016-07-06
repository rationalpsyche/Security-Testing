package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddClass extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Classes", "classes");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Class");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Classes", "classes");
		tester.setHiddenField("page2", "9"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='classes']", tester);
		tester.submit();
		tester.assertMatch("Add New Class");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

	@Test
	public void fieldFullYear() {
		this.navigateTo("Classes", "classes");
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Class");
		tester.setWorkingForm("addclass");
		tester.setHiddenField("fullyear", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"addclass\"]",tester);
	    tester.submit(); 
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
}