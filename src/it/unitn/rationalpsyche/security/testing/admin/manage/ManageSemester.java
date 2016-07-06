package it.unitn.rationalpsyche.security.testing.admin.manage;

import it.unitn.rationalpsyche.security.testing.utilities.Database;
import it.unitn.rationalpsyche.security.testing.utilities.Methods;

import org.junit.Test;
import org.junit.After;

public class ManageSemester extends it.unitn.rationalpsyche.security.testing.BaseAdmin {
	@Test
	public void fieldPage() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page", "1"+this.pattern1);
		tester.clickLinkWithText("Semesters");
		tester.assertMatch("Manage Semesters");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldPage2() {
		tester.setWorkingForm("admin");
		tester.setHiddenField("page2", "5"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name=\"admin\"]", tester);
		tester.submit();
		tester.assertMatch("Manage Semesters");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void onPage() {
		this.navigateTo("Semesters","semesters");
		tester.setHiddenField("onpage", "1"+this.pattern1);
		Methods.newSubmitButton("/html//form[@name='semesters']", tester);
		tester.submit();
		tester.assertMatch("Manage Semesters");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void term() {
		this.navigateTo("Terms", "terms");
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Term");
		tester.setWorkingForm("addterm");
		tester.setTextField("title", "<a href>T</a>");
		tester.setTextField("startdate", "1");
		tester.setTextField("enddate", "2");
		tester.clickButtonWithText("Add Term");
		this.navigateTo("Semesters", "semesters");
		tester.clickButtonWithText("Add");
		tester.setWorkingForm("addsemester");
		tester.setTextField("title", "foo");
		tester.setTextField("startdate", "1");
		tester.setTextField("middate", "2");
		tester.setTextField("enddate", "3");
		try {
			tester.selectOption("term", "T");
			tester.clickButtonWithText("Add Semester");
			tester.assertMatch("Manage Semesters");
			tester.assertLinkNotPresentWithExactText("T");
		}
		catch (AssertionError ae) {
			System.out.println("Injection was not possible");
		}
	}
	
	@After
	public void restore() {
		Integer status = Database.queryDB("DELETE from terms WHERE title LIKE '%T</a>%'");
		System.out.println("Status of restore terms: "+status);
		status = Database.queryDB("DELETE from semesters WHERE title = 'Foo'");
		System.out.println("Status of restore semesters: "+status);
		
	}
}
