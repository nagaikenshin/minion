package org.kyojo.gson;

import java.util.Comparator;

public class JsonElementKeyComparator implements Comparator<JsonElement> {

	@Override
	public int compare(JsonElement je1, JsonElement je2) {
		return je1.getAsString().compareTo(je2.getAsString());
	}

}
