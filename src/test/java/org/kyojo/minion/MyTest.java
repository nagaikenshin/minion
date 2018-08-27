package org.kyojo.minion;

import static org.junit.Assert.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

public class MyTest {

	@Test
	public void testMinionNull() {
		String mnn = My.minion(null);
		assertEquals("null", mnn);
	}

	@Test
	public void testMinionString() {
		String mnn = My.minion("dame");
		assertEquals("\"dame\"", mnn);
	}

	private SkinSKey obj01Spc = new SkinSKey();

	// private String mnn01Spc = "{\"key\":\"だめ人間{\\\"LF\\nbel\\a\",\"opt\":\"ningen\",\"rid\":\"dame\",\"thisIsFalse\":false,\"thisIsNull\":null}";
	private String mnn01Spc = "{\"key\":\"だめ人間{\\\"LF\\nbel\\a\",\"opt\":\"ningen\",\"rid\":\"dame\",\"thisIsFalse\":false,\"thisIsPrivate\":\"Private\",\"thisIsProtected\":\"Protected\"}";

	@Test
	public void testMinion01_1() {
		String mnn01Out = My.minion(obj01Spc);
		System.out.println("out01: " + mnn01Out);
		System.out.println("spc01: " + mnn01Spc);
		assertEquals(mnn01Spc, mnn01Out);
	}

	@Test
	public void testMinion01_2() {
		SkinSKey obj01Out = My.deminion(mnn01Spc, SkinSKey.class);
		System.out.println(ToStringBuilder.reflectionToString(obj01Out));
		assertEquals(obj01Spc, obj01Out);
	}

	private SkinSKey2 obj02Spc = new SkinSKey2();

	// private String mnn02Spc = "{\"multiMap\":{\"c1\":{\"c11\":\"a\",\"c12\":\"b\",\"c13\":\"c\"},\"c2\":{\"c21\":\"d\"},\"c3\":{},\"c4\":null,\"c5\":{\"c51\":\"d\"}},\"opt\":\"ningen\",\"rid\":\"dame\",\"thisIsObject\":{\"XYZ\":\"UVW\",\"_1\":0,\"abc\":\"def\",\"complex1\":{\"co:lo:,n\":\"cccc\\\\\\\\\",\"complex11\":\"aaa\",\"complex12\":\"bb,\\\"b\",\"complex13\":[\"{\\\"\\\",]{:\\\\abc\",3.14159]},\"日本語\":\"ですよ\"}}";
	private String mnn02Spc = "{\"multiMap\":{\"c1\":{\"c11\":\"a\",\"c12\":\"b\",\"c13\":\"c\"},\"c2\":{\"c21\":\"d\"},\"c3\":{},\"c5\":{\"c51\":\"d\"}},\"opt\":\"ningen\",\"rid\":\"dame\",\"thisIsObject\":{\"XYZ\":\"UVW\",\"_1\":0,\"abc\":\"def\",\"complex1\":{\"co:lo:,n\":\"cccc\\\\\\\\\",\"complex11\":\"aaa\",\"complex12\":\"bb,\\\"b\",\"complex13\":[\"{\\\"\\\",]{:\\\\abc\",3.14159]},\"日本語\":\"ですよ\"},\"thisIsPrivate\":\"Private\",\"thisIsProtected\":\"Protected\"}";

	@Test
	public void testMinion02_1() {
		String mnn02Out = My.minion(obj02Spc);
		System.out.println("out02: " + mnn02Out);
		System.out.println("spc02: " + mnn02Spc);
		assertEquals(mnn02Spc, mnn02Out);
	}

	@Test
	public void testMinion02_2() {
		SkinSKey2 obj02Out = My.deminion(mnn02Spc, SkinSKey2.class);
		System.out.println(ToStringBuilder.reflectionToString(obj02Spc));
		System.out.println(ToStringBuilder.reflectionToString(obj02Out));
		assertNotEquals(obj02Spc, obj02Out);
		obj02Out.multiMap.put("c4", null);
		assertEquals(obj02Spc, obj02Out);
	}

	private SkinSKey3 obj03Spc = new SkinSKey3();

	// private String mnn03Spc = "{\"justAnArray\":[true,\"だめ人間\",null,{\"ke[y2\\\\\\\",\":\"b\\\\\\\\\\\\\\\",bb\\u0027\",\"ke]y{1:\":\":a{]aa\"},[\"def{\",\"ghi\",\"a\\\"bc\"],[-1,0,3,200],{\"-100.1\":100,\"-5.5E-15\":100,\"4.0E-4\":100,\"4.51\":100}],\"opt\":\"ningen\",\"rid\":\"dame\"}";
	private String mnn03Spc = "{\"justAnArray\":[true,\"だめ人間\",null,{\"ke[y2\\\\\\\",\":\"b\\\\\\\\\\\\\\\",bb\\u0027\",\"ke]y{1:\":\":a{]aa\"},[\"def{\",\"ghi\",\"a\\\"bc\"],[-1,0,3,200],{\"-100.1\":100,\"-5.5E-15\":100,\"4.0E-4\":100,\"4.51\":100}],\"opt\":\"ningen\",\"rid\":\"dame\",\"thisIsPrivate\":\"Private\",\"thisIsProtected\":\"Protected\"}";

	@Test
	public void testMinion03_1() {
		String mnn03Out = My.minion(obj03Spc);
		System.out.println("out03: " + mnn03Out);
		System.out.println("spc03: " + mnn03Spc);
		assertEquals(mnn03Spc, mnn03Out);
	}

	@Test
	public void testMinion03_2() {
		SkinSKey3 obj03Out = My.deminion(mnn03Spc, SkinSKey3.class);
		System.out.println(ToStringBuilder.reflectionToString(obj03Out));
		assertEquals(obj03Spc, obj03Out);
	}

	@Test
	public void testTableize() {
		assertEquals("abc__def_ghi", My.tableize("abc.defGhi"));
	}

	@Test
	public void testPascalize() {
		assertEquals("Abc.DefGhi", My.pascalize("abc__def_ghi"));
	}

	@Test
	public void testCamelize() {
		assertEquals("abc.defGhi", My.camelize("abc__def_ghi"));
	}

	@Test
	public void testConstantize() {
		assertEquals("ABC__DEF_GHI", My.constantize("abc.defGhi"));
	}

	@Test
	public void testMagicalize() {
		assertEquals("__ABC__DEF_GHI__", My.magicalize("abc.defGhi"));
	}

}

