package it.unitn.rationalpsyche.security.testing.admin.manage;

import it.unitn.rationalpsyche.security.testing.utilities.Database;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;
import org.junit.After;

public class ManageAnnouncement extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickLinkWithText("Announcement");
		tester.assertMatch("Manage Announcement");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page2", "4"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"admin\"]", tester);
		tester.submit();
		tester.assertMatch("Manage Announcement");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void onPage() {
		this.navigateTo("Announcement","announcements");
		tester.setHiddenField("onpage", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='announcements']", tester);
		tester.submit();
		tester.assertMatch("Manage Announcement");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void message() { // Stored XSS not found by pixy
		this.navigateTo("Announcement","announcements");
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Announcement");
		tester.setWorkingForm("addannouncement");
		tester.setTextField("title", "Foo");
		tester.setTextField("message", "<a href=\"http://unitn.it\">Drive by download</a>");
		tester.clickButtonWithText("Add announcement");
		tester.assertLinkNotPresentWithText("Drive by download");
	}

	@After
	public void restore() {
		Integer status = Database.queryDB("DELETE from schoolbulletins WHERE message LIKE '%Drive by download%'");
		System.out.println("Status of restore announcements: "+status);
	}
}

