package C5.test;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.TestCase;

public class S5_3 extends TestCase {

	@Test
	public void testCase_E5_5() {
		List<Integer> numbers = asList(1, 2, 3, 4, 5);
		TreeSet<Integer> numbersTreeSet = numbers.stream().collect(toCollection(TreeSet::new));
		assertEquals(Stream.of(1, 2, 3, 4, 5).collect(toSet()), numbersTreeSet);
	}

}
