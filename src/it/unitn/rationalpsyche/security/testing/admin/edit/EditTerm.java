package it.unitn.rationalpsyche.security.testing.admin.edit;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class EditTerm extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Terms", "terms");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Terms", "terms");
		
		tester.setHiddenField("page2", "12"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		Methods.newSubmitButton("/html//form[@name='terms']", tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}

