package it.unitn.rationalpsyche.security.testing.admin.edit;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class EditClass extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Classes", "classes");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Classes", "classes");
		
		tester.setHiddenField("page2", "11"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		Methods.newSubmitButton("/html//form[@name='classes']", tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void id() {
		this.navigateTo("Classes", "classes");
		
		tester.getElementByXPath("//input[@type='checkbox' and @value='1']").setAttribute("value",this.pattern2);
		tester.checkCheckbox("delete[]");
		
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}

