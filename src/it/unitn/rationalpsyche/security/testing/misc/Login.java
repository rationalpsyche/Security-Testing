package it.unitn.rationalpsyche.security.testing.misc;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;
import org.junit.After;

public class Login extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	
	@Test
	public void fieldSiteText() {
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		tester.setWorkingForm("info");
		tester.setTextField("sitetext", "<a href=\"www.unitn.it\">Evil</a>");
		tester.assertMatch("Manage School Information");
		tester.clickButtonWithText(" Update ");
		tester.clickLinkWithText("Log Out");
		tester.assertLinkNotPresentWithText("Evil");
	}
	
	@Test
	public void fieldSiteMessage() {
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		tester.setWorkingForm("info");
		tester.setTextField("sitemessage","<a href=\"www.unitn.it\">Evil</a>");
		tester.assertMatch("Manage School Information");
		tester.clickButtonWithText(" Update ");
		tester.clickLinkWithText("Log Out");
		tester.assertLinkNotPresentWithText("Evil");
	}
	
	@After
	public void restore() {
		this.prepare();
		tester.clickLinkWithText("School");
		tester.setWorkingForm("info");
		Methods.restoreSchoolInfo(tester);
	}
	

}
