package C5;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

public class S5_2 extends TestCase {

	/**
	 * 例5-1 顺序测试永远通过<br />
	 */
	@Test
	public void testCase_E5_1() {
		List<Integer> numbers = asList(1, 2, 3, 4);
		List<Integer> sameOrder = numbers.stream().collect(toList());
		assertEquals(numbers, sameOrder);
	}

	/**
	 * 例5-2 顺序测试不能保证每次通过<br />
	 */
	@Test
	public void testCase_E5_2() {
		Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
		List<Integer> sameOrder = numbers.stream().collect(toList());
		assertEquals(asList(4, 3, 2, 1), sameOrder);
	}

	/**
	 * 例5-3 生成出现顺序<br />
	 */
	@Test
	public void testCase_E5_3() {
		Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
		List<Integer> sameOrder = numbers.stream().sorted().collect(toList());
		assertEquals(asList(1, 2, 3, 4), sameOrder);
	}

	/**
	 * 例5-4 本例中关于顺序的假设永远是正确的<br />
	 */
	@Test
	public void testCase_E5_4() {
		List<Integer> numbers = asList(1, 2, 3, 4);
		List<Integer> stillOrdered = numbers.stream()
											.map(x -> x + 1)
											.collect(toList());
		// 顺序得到了保留
		assertEquals(asList(2, 3, 4, 5), stillOrdered);
		
//		Set<Integer> unordered = new HashSet<>(numbers);
//		List<Integer> stillUnordered = unordered.stream()
//												.map(x -> x + 1)
//												.collect(toList());
//		// 顺序得不到保证
//		assertThat(stillUnordered, hasItem(2));
//		assertThat(stillUnordered, hasItem(3));
//		assertThat(stillUnordered, hasItem(4));
//		assertThat(stillUnordered, hasItem(5));
	}
}