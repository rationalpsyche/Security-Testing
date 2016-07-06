package it.unitn.rationalpsyche.security.testing;

/*
 * Remark: all the classes in the admin sub-packages could extend directly
 * TopClass as BaseAdmin does not provide any additional method however
 * I could not know it in advance so I created this class to be more flexible
 * */
public class BaseAdmin extends TopClass {
	@Override
	public void setCredentials() {
		this.username = "schoolmate";
		this.password = "schoolmate";
	}
}