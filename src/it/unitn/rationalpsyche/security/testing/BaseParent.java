package it.unitn.rationalpsyche.security.testing;

public class BaseParent extends TopClass {
	@Override
	public void setCredentials() {
		this.username = "enzo";
		this.password = "enzo";
	}
	
	public void selectClass() {
		tester.assertMatch("Students of Enzo Rossi");
		tester.clickLinkWithText("Patrick Rossi");
		tester.assertMatch("Patrick Rossi's Classes");
		tester.clickLinkWithText("NetSec");
		tester.assertMatch("Class Settings");
	}
}
