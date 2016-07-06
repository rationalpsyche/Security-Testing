package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddAnnouncement extends it.unitn.rationalpsyche.security.testing.BaseAdmin  {

	@Test
	public void fieldPage() {
		this.navigateTo("Announcements", "announcements");
		tester.setTextField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Announcement");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2() {
		this.navigateTo("Announcements", "announcements");
		tester.setTextField("page2", "18"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"announcements\"]", tester);
		tester.submit();
		tester.assertMatch("Add New Announcement");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
}