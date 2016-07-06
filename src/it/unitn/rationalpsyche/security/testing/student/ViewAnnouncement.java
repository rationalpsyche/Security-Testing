package it.unitn.rationalpsyche.security.testing.student;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;

public class ViewAnnouncement extends it.unitn.rationalpsyche.security.testing.BaseStudent {
	@Test
	public void fieldPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page", "5"+this.pattern1);
		tester.clickLinkWithExactText("Announcements");
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.setTextField("page2", "4"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='student']", tester);
		tester.submit();
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void onPage() {
		this.selectClass();
		tester.setWorkingForm("student");
		tester.clickLinkWithText("Announcements");
		tester.assertMatch("View Announcements");
		tester.setTextField("onpage", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='announcements']", tester);
		tester.submit();
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
}
