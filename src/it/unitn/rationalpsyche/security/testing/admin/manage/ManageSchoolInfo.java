package it.unitn.rationalpsyche.security.testing.admin.manage;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;
import org.junit.After;

public class ManageSchoolInfo extends it.unitn.rationalpsyche.security.testing.BaseAdmin {

	public void navigateTo() {
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		tester.setWorkingForm("info");
	}
	
	@Test
	public void fieldPage() {
		this.navigateTo();
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText(" Update ");
		tester.assertMatch("Manage School Information");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo();
		tester.setHiddenField("page", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='info']", tester);
		tester.submit();
		tester.assertMatch("Manage School Information");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test 
	public void phone() {
		this.navigateTo();
		tester.setTextField("schoolphone", "<a href=#>A");
		tester.clickButtonWithText(" Update ");
		tester.assertMatch("Manage School Information");
		tester.assertLinkNotPresentWithExactText("A");		
	}
	@Test 
	public void address() {
		this.navigateTo();
		tester.setTextField("schooladdress","''><a href=goo.gl>Mal</a>");
		tester.clickButtonWithText(" Update ");
		tester.assertMatch("Manage School Information");
		tester.assertLinkNotPresentWithText("Mal");		
	}
	
	@After
	public void restore() {
		this.navigateTo();
		Methods.restoreSchoolInfo(tester);
		
	}

}
