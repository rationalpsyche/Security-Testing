package it.unitn.rationalpsyche.security.testing.admin.add;
import org.junit.Test;

import it.unitn.rationalpsyche.security.testing.utilities.Methods;

public class AddSemester extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		this.navigateTo("Semesters", "semesters");
		
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickButtonWithText("Add");
		
		tester.assertMatch("Add New Semester");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}
	
	@Test
	public void fieldPage2() {
		this.navigateTo("Semesters", "semesters");
		
		tester.setHiddenField("page2", "7"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='semesters']", tester);
		tester.submit();
		tester.assertMatch("Add New Semester");
		tester.assertLinkNotPresentWithText(this.assertInjection);
		
	}

}