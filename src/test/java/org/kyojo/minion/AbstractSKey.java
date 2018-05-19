package org.kyojo.minion;

public class AbstractSKey {

	public String rid = "dame";
	public String opt = "ningen";
	protected String thisIsProtected = "Protected";
	private String thisIsPrivate = "Private";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opt == null) ? 0 : opt.hashCode());
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
		result = prime * result + ((thisIsPrivate == null) ? 0 : thisIsPrivate.hashCode());
		result = prime * result + ((thisIsProtected == null) ? 0 : thisIsProtected.hashCode());
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
		AbstractSKey other = (AbstractSKey) obj;
		if (opt == null) {
			if (other.opt != null)
				return false;
		} else if (!opt.equals(other.opt))
			return false;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		if (thisIsPrivate == null) {
			if (other.thisIsPrivate != null)
				return false;
		} else if (!thisIsPrivate.equals(other.thisIsPrivate))
			return false;
		if (thisIsProtected == null) {
			if (other.thisIsProtected != null)
				return false;
		} else if (!thisIsProtected.equals(other.thisIsProtected))
			return false;
		return true;
	}

}
