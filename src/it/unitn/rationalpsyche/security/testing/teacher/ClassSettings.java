package it.unitn.rationalpsyche.security.testing.teacher;
import org.junit.Test;

public class ClassSettings extends it.unitn.rationalpsyche.security.testing.BaseTeacher {
	@Test
	public void fieldPage(){
		selectClass();
		navigateTo2("Settings","classes");
		tester.setHiddenField("page", "2"+this.pattern1);
		tester.clickButtonWithText("Update");
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	@Test
	public void fieldPage2(){
		selectClass();
		navigateTo2("Settings","classes");
		tester.setHiddenField("page2", "1"+this.pattern1);
		tester.clickButtonWithText("Update");
		tester.assertMatch("Class Settings");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}
	
	@Test
	public void fieldSelectClass(){
		selectClass();
		navigateTo2("Settings","classes");
		tester.setHiddenField("selectclass", "1"+this.pattern1);
		tester.clickButtonWithText("Update");
		//tester.assertMatch("ClassSettings.php: Unable to update");
		tester.assertLinkNotPresentWithText(this.assertInjection);
	}

}
