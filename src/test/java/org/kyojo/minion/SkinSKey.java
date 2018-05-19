package org.kyojo.minion;

public class SkinSKey extends AbstractSKey {

	public String key = "だめ人間{\"LF\nbel\u0007";
	public String thisIsNull = null;
	public Boolean thisIsFalse = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((thisIsFalse == null) ? 0 : thisIsFalse.hashCode());
		result = prime * result + ((thisIsNull == null) ? 0 : thisIsNull.hashCode());
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
		SkinSKey other = (SkinSKey) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (thisIsFalse == null) {
			if (other.thisIsFalse != null)
				return false;
		} else if (!thisIsFalse.equals(other.thisIsFalse))
			return false;
		if (thisIsNull == null) {
			if (other.thisIsNull != null)
				return false;
		} else if (!thisIsNull.equals(other.thisIsNull))
			return false;
		return true;
	}

}
