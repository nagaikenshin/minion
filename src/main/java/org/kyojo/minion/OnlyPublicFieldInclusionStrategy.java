package org.kyojo.minion;

import java.lang.reflect.Modifier;

import org.kyojo.gson.ExclusionStrategy;
import org.kyojo.gson.FieldAttributes;

public class OnlyPublicFieldInclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return !f.hasModifier(Modifier.PUBLIC);
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

}
