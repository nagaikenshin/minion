package org.kyojo.minion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SkinSKey2 extends AbstractSKey {

	public ThisIsObject thisIsObject = new ThisIsObject();

	public Map<String, Map<String, String>> multiMap = new HashMap<String, Map<String, String>>();

	public SkinSKey2() {
		HashMap<String, String> tmpMap5 = new HashMap<String, String>();
		tmpMap5.put("c51", "d");
		multiMap.put("c5", tmpMap5);
		multiMap.put("c4", null);
		HashMap<String, String> tmpMap1 = new HashMap<String, String>();
		tmpMap1.put("c11", "a");
		tmpMap1.put("c13", "c");
		tmpMap1.put("c12", "b");
		multiMap.put("c1", tmpMap1);
		HashMap<String, String> tmpMap2 = new HashMap<String, String>();
		tmpMap2.put("c21", "d");
		multiMap.put("c2", tmpMap2);
		HashMap<String, String> tmpMap3 = new HashMap<String, String>();
		multiMap.put("c3", tmpMap3);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((multiMap == null) ? 0 : multiMap.hashCode());
		result = prime * result + ((thisIsObject == null) ? 0 : thisIsObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkinSKey2 other = (SkinSKey2) obj;
		if (multiMap == null) {
			if (other.multiMap != null)
				return false;
		} else if (!multiMap.equals(other.multiMap))
			return false;
		if (thisIsObject == null) {
			if (other.thisIsObject != null)
				return false;
		} else if (!thisIsObject.equals(other.thisIsObject))
			return false;
		return true;
	}

}

class ThisIsObject {

	public Integer _1 = 0;

	public String XYZ = "UVW";

	public String abc = "def";

	public String 日本語 = "ですよ";

	public Map<String, Object> complex1 = new HashMap<String, Object>();

	public ThisIsObject() {
		complex1.put("complex12", "bb,\"b");
		complex1.put("complex11", "aaa");
//		complex1.put("complex13", new Object[] { "{\"\",]{:\\abc", new Double(3.14159) }); // Listにしないと可逆変換できない
		complex1.put("complex13", Arrays.asList(new Object[] { "{\"\",]{:\\abc", new Double(3.14159) }));
		complex1.put("co:lo:,n", "cccc\\\\");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((XYZ == null) ? 0 : XYZ.hashCode());
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((abc == null) ? 0 : abc.hashCode());
		result = prime * result + ((complex1 == null) ? 0 : complex1.hashCode());
		result = prime * result + ((日本語 == null) ? 0 : 日本語.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThisIsObject other = (ThisIsObject) obj;
		if (XYZ == null) {
			if (other.XYZ != null)
				return false;
		} else if (!XYZ.equals(other.XYZ))
			return false;
		if (_1 == null) {
			if (other._1 != null)
				return false;
		} else if (!_1.equals(other._1))
			return false;
		if (abc == null) {
			if (other.abc != null)
				return false;
		} else if (!abc.equals(other.abc))
			return false;
		if (complex1 == null) {
			if (other.complex1 != null)
				return false;
		} else if (!complex1.equals(other.complex1))
			return false;
		if (日本語 == null) {
			if (other.日本語 != null)
				return false;
		} else if (!日本語.equals(other.日本語))
			return false;
		return true;
	}

}
