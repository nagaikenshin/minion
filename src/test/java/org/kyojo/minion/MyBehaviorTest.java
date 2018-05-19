package org.kyojo.minion;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBehaviorTest {

	@Test
	public void testMyPascalize() {
		String res01 = My.pascalize("url");
		assertEquals("Url", res01);
		String res02 = My.pascalize("urlA");
		assertEquals("UrlA", res02);
		String res03 = My.pascalize("co2");
		assertEquals("Co2", res03);
	}

}
