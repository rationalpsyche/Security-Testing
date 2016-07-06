package it.unitn.rationalpsyche.security.testing.admin.edit;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class EditStudent extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Students", "students");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Students", "students");
		
		tester.setHiddenField("page2", "21"+this.pattern1);
		tester.checkCheckbox("delete[]","1");
		Methods.newSubmitButton("/html//form[@name='students']", tester);
		tester.submit();
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void id() {
		this.navigateTo("Students", "students");
		
		tester.getElementByXPath("//input[@type='checkbox' and @value='1']").setAttribute("value",this.pattern2);
		tester.checkCheckbox("delete[]");
		
		tester.clickButtonWithText("Edit");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}

