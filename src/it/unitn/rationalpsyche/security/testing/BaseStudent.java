package it.unitn.rationalpsyche.security.testing;

public class BaseStudent extends TopClass {
	@Override
	public void setCredentials() {
		this.username = "patrick";
		this.password = "patrick";
	}
	
	public void selectClass() {
		tester.assertMatch("Patrick Rossi's Classes");
		tester.clickLinkWithText("NetSec");
		tester.assertMatch("Class Settings");
	}
}
