package entity;

import java.util.List;

public class Artist {
	private String name;
	private List<String> members;
	private boolean isSolo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public boolean isSolo() {
		return isSolo;
	}

	public void setSolo(boolean isSolo) {
		this.isSolo = isSolo;
	}

	@Override
	public String toString() {
		return "Artist [name=" + name + ", members=" + members + ", isSolo=" + isSolo + "]";
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj == null ? false : this.hashCode() == obj.hashCode();
	}

}
