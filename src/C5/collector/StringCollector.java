package C5.collector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String, StringJoiner, String> {

	private String delim;
	private String prefix;
	private String suffix;

	public StringCollector(String delim, String prefix, String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	@Override
	public Supplier<StringJoiner> supplier() {
		return () -> new StringJoiner(delim, prefix, suffix);
	}

	@Override
	public BiConsumer<StringJoiner, String> accumulator() {
		return StringJoiner::add;
	}

	@Override
	public BinaryOperator<StringJoiner> combiner() {
		return StringJoiner::merge;
	}

	@Override
	public Function<StringJoiner, String> finisher() {
		return StringJoiner::toString;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return new HashSet<Characteristics>(Arrays.asList(Characteristics.IDENTITY_FINISH));
	}

}
