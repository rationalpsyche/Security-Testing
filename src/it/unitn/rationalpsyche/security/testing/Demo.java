package it.unitn.rationalpsyche.security.testing;

import it.unitn.rationalpsyche.security.testing.utilities.Database;

import org.junit.Test;

public class Demo {
	@Test
	public void foo() {
		Integer status = Database.queryDB("DELETE from assignments WHERE title = 'Red'");
		if (status != 1)
			System.out.println(status);
		else
			System.out.println("Something went wrong");
	}
}
