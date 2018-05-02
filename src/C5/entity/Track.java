package C5.entity;

public class Track {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Track [name=" + name + "]";
	}

}
