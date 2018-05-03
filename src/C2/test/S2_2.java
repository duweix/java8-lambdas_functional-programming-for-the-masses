package C2.test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

import org.junit.Test;

import junit.framework.TestCase;

public class S2_2 extends TestCase {

	/**
	 * 例2-3 编写Lambda表达式的不同形式
	 */
	@Test
	public void testCase_E2_3() {
		Runnable noArguments = () -> System.out.println("Hello, World!");

		ActionListener oneArgument = event -> System.out.println("button clicked");

		final String helloWorldMessage = "Hello, World!";
//		helloWorldMessage = "";
		Runnable multiStatement = () -> {
//			System.out.print("Hello,");
//			System.out.println(" World!");
			System.out.println(helloWorldMessage);
		};
		multiStatement.run();

		BinaryOperator<Long> add = (x, y) -> x + y;

		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		assertEquals(new Long(9), addExplicit.apply(3L, 6L));
	}
}
