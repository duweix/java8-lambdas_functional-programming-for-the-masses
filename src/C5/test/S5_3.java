package C5.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import C5.entity.Artist;
import junit.framework.TestCase;

public class S5_3 extends TestCase {

	/**
	 * 便5-5 使用toCollection，用定制的集合收集元素
	 */
	@Test
	public void testCase_E5_5() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		TreeSet<Integer> numbersTreeSet = numbers.stream().collect(Collectors.toCollection(TreeSet::new));
		assertEquals(Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet()), numbersTreeSet);
	}

	/**
	 * 便5-6 找出成员最多的乐队
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

}
