package org.kyojo.minion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SkinSKey3 extends AbstractSKey {

	public Object[] justAnArray = new Object[] {
			new Boolean(true),
			"だめ人間",
			null,
			null,
			null,
			null,
			null
	};

	public SkinSKey3() {
		Map<String, String> justAStringMap = new HashMap<String, String>();
		justAStringMap.put("ke]y{1:", ":a{]aa");
		justAStringMap.put("ke[y2\\\",", "b\\\\\\\",bb'");
		justAnArray[3] = justAStringMap;
		List<String> justAList = new ArrayList<String>();
		justAList.add("def{");
		justAList.add("ghi");
		justAList.add("a\"bc");
		justAnArray[4] = justAList;
		Set<Integer> justASet = new HashSet<Integer>();
		justASet.add(200);
		justASet.add(-1);
		justASet.add(3);
		justASet.add(0);
		justAnArray[5] = justASet;
		Map<Double, Integer> justADoubleMap = new HashMap<Double, Integer>();
		justADoubleMap.put(0.0004, 100);
		justADoubleMap.put(-100.1, 100);
		justADoubleMap.put(4.51, 100);
		justADoubleMap.put(-5.5E-15, 100);
		justAnArray[6] = justADoubleMap;
	}

}
