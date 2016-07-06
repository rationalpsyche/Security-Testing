package it.unitn.rationalpsyche.security.testing.utilities;

//these packages are needed for the newSubmitButton
import org.xml.sax.helpers.AttributesImpl;
import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;

import com.gargoylesoftware.htmlunit.html.InputElementFactory;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class Methods {
	static String address = "Via Sommarive Povo";
	static String phone = "52365895";
	static String numsemesters = "2";
	static String numperiods = "5";
	static String sitetext = "This is a login page aye!";
	static String sitemessage = "Knowledge is power - Francis Bacon";
	
	public static void newSubmitButton(String fromXpath,WebTester tester) {
		IElement element = tester.getElementByXPath(fromXpath);
		DomElement form =((HtmlUnitElementImpl)element).getHtmlElement();
		InputElementFactory factory = InputElementFactory.instance;
		AttributesImpl attributes = new AttributesImpl();
		attributes.addAttribute("","","type","","submit");
		HtmlElement submit = factory.createElement(form.getPage(),"input",attributes);
		form.appendChild(submit);
	}
	
	public static void restoreSchoolInfo(WebTester tester) {
		
		tester.setTextField("schooladdress", address);
		tester.setTextField("schoolphone", phone);
		tester.setTextField("numsemesters", numsemesters);
		tester.setTextField("numperiods",numperiods);
		tester.setTextField("sitemessage", sitemessage);
		tester.setTextField("sitetext", sitetext);
		tester.clickButtonWithText(" Update ");
		tester.assertMatch("Manage School Information");
	}

}
