package entity;

import java.util.List;

public class Album {
	private String name;
	private List<Track> trackList;
	private Artist mainMusician;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

	public Artist getMainMusician() {
		return mainMusician;
	}

	public void setMainMusician(Artist mainMusician) {
		this.mainMusician = mainMusician;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", trackList=" + trackList + ", mainMusician=" + mainMusician + "]";
	}

}
