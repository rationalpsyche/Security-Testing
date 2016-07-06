package it.unitn.rationalpsyche.security.testing;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.Before;

public class TopClass {
	public WebTester tester; 
	
	public String username;
	public String password;
	
	public String link = "<a href=\"http://unitn.it\">Malicious Link</a><br '";
	
	public String pattern1 = "' /> "+link;
	public String pattern2 = "1 -- ' />" +link;
	public String pattern3 = "1)-- ' />"+link;
	public String pattern4 = "1' -- '>"+link;
	public String assertInjection = "Malicious Link";
	
	public void setCredentials() {
		this.username = "schoolmate";
		this.password = "schoolmate";
	}
	
	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost/sec-test/schoolmate");
		tester.beginAt("/index.php");
		setCredentials();
		tester.setTextField("username",username);
		tester.setTextField("password",password);
		tester.submit();

		tester.assertTitleEquals("SchoolMate - Unitn");
	}
	
	public void navigateTo(String page,String formName) {
		tester.clickLinkWithText(page);
		tester.assertMatch("Manage "+page);
		tester.setWorkingForm(formName);
		
	}
	
	public void navigateTo2(String page,String formName) {
		tester.clickLinkWithText(page);
		tester.assertMatch(page);
		tester.setWorkingForm(formName);
		
	}
}
