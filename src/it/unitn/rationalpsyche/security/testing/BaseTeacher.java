package it.unitn.rationalpsyche.security.testing;

public class BaseTeacher extends TopClass {
	@Override
	public void setCredentials() {
		this.username = "allodi";
		this.password = "allodi";
	}
	
	public void selectClass() {
		tester.assertMatch("Luca Allodi's Classes");
		tester.clickLinkWithText("NetSec");
		tester.assertMatch("Class Settings");
	}
}
