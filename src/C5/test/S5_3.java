package C5.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import C5.entity.Album;
import C5.entity.Artist;
import C5.entity.Track;
import junit.framework.TestCase;

public class S5_3 extends TestCase {

	/**
	 * 例5-5 使用toCollection，用定制的集合收集元素
	 */
	@Test
	public void testCase_E5_5() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		TreeSet<Integer> numbersTreeSet = numbers.stream().collect(Collectors.toCollection(TreeSet::new));
		assertEquals(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet()), numbersTreeSet);
	}

	/**
	 * 例5-6 找出成员最多的乐队
	 */
	@Test
	public void testCase_E5_6() {
		List<Artist> artists = new ArrayList<>();
		Artist artist1 = new Artist();
		artist1.setMembers(Arrays.asList("A1", "A2", "A3"));
		Artist artist2 = new Artist();
		artist2.setMembers(Arrays.asList("B1", "B2", "B3"));
		artists.add(artist1);
		artists.add(artist2);

		Optional<Artist> opArtist = biggestGroup(artists.stream());
		assertEquals(Arrays.asList("A1", "A2", "A3"), opArtist.get().getMembers());
	}

	private Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist, Integer> getCount = artist -> artist.getMembers().size();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}

	/**
	 * 例5-7 找出一组专辑上曲目的平均数
	 */
	@Test
	public void testCase_E5_7() {
		List<Album> albums = new ArrayList<>();

		Album album;
		Track track;
		List<Track> trackList;

		album = new Album();
		trackList = new ArrayList<>();
		track = new Track();
		trackList.add(track);
		album.setTrackList(trackList);
		albums.add(album);

		album = new Album();
		trackList = new ArrayList<>();
		album.setTrackList(trackList);
		albums.add(album);

		assertEquals(0.5D, averageNumberOfTracks(albums));
	}

	private double averageNumberOfTracks(List<Album> albums) {
		return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
	}

	/**
	 * 例5-8 将艺术家组成的流分成乐队和独唱歌手两部分
	 */
	@Test
	public void testCase_E5_8() {
		List<Artist> artists = new ArrayList<>();
		Artist artist = null;

		artist = new Artist();
		artist.setSolo(true);
		artists.add(artist);

		artist = new Artist();
		artist.setSolo(false);
		artists.add(artist);

		artist = new Artist();
		artist.setSolo(true);
		artists.add(artist);

		Map<Boolean, List<Artist>> artistsGrouped = artists.stream()
				.collect(Collectors.partitioningBy(_artist -> _artist.isSolo()));
		// 例5-9 使用方法引用将艺术家组成的Stream分成乐队和独唱歌手两部分
		// Map<Boolean, List<Artist>> artistsGrouped = artists.stream()
		// .collect(Collectors.partitioningBy(Artist::isSolo));
		assertEquals(2, artistsGrouped.size());
	}
}
