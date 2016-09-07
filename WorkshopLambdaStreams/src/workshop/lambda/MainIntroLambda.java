package workshop.lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MainIntroLambda {

	public static void main(String[] args) {
		MainIntroLambda mil = new MainIntroLambda();

		System.out.println("< Java 1.8");
		mil.fibonacci1();

		System.out.println("Java 1.2");
		mil.fibonacci2();

		System.out.println("Java 1.5");
		mil.fibonacci3();

		System.out.println("Lambda - Java 1.8");
		mil.fibonacciLambda();

		System.out.println("Lambda/Consumer - Java 1.8");
		mil.fibonacciLambdaConsumer();

		System.out.println("Lambda/Consumer em Bloco Anônimo - Java 1.8");
		mil.fibonacciLambdaConsumerBlocoAnonimo();

		System.out.println("Lambda/Consumer em Bloco Anônimo/Redução 1 - Java 1.8");
		mil.fibonacciLambdaConsumerBlocoAnonimoReducao1();

		System.out.println("Lambda/Consumer em Bloco Anônimo/Redução 2 - Java 1.8");
		mil.fibonacciLambdaConsumerBlocoAnonimoReducao2();

		System.out.println("Lambda/Consumer em Bloco Anônimo/Redução 3 - Java 1.8");
		mil.fibonacciLambdaConsumerBlocoAnonimoReducao3();

		System.out.println("Lambda/Consumer em Bloco Anônimo/Redução Extra - Java 1.8");
		mil.fibonacciLambdaConsumerBlocoAnonimoReducaoExtra();
	}

	/**
	 * Fibonacci sem Lambda (< Java 1.8)
	 */
	private void fibonacci1() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		for (int i = 0; i < numbers.size(); i++) {
			int number = numbers.get(i);

			System.out.println(number);
		}
	}

	/**
	 * Fibonacci sem Lambda (Java 1.2)
	 */
	private void fibonacci2() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		Iterator<Integer> iNumbers = numbers.iterator();

		while (iNumbers.hasNext()) {
			Integer number = iNumbers.next();

			System.out.println(number);
		}
	}

	/**
	 * Fibonacci sem Lambda (Java 1.5)
	 */
	private void fibonacci3() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		for (Integer number : numbers) {
			System.out.println(number);
		}
	}

	/**
	 * Fibonacci com Lambda (Java 1.8)
	 */
	private void fibonacciLambda() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach((Integer n) -> System.out.println(n));

		numbers.forEach(n -> System.out.println(n));

		numbers.forEach(System.out::println);
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> (Java 1.8)
	 */
	private void fibonacciLambdaConsumer() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach(new Mostrador());
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> em Bloco Anônimo (Java 1.8)
	 */
	private void fibonacciLambdaConsumerBlocoAnonimo() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer number) {
				System.out.println(number);
			}
		});
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> em Bloco Anônimo/Redução 1 (Java
	 * 1.8)
	 */
	private void fibonacciLambdaConsumerBlocoAnonimoReducao1() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach((Integer number) -> {
			System.out.println(number);
		});
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> em Bloco Anônimo/Redução 2 (Java
	 * 1.8)
	 */
	private void fibonacciLambdaConsumerBlocoAnonimoReducao2() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach(number -> {
			System.out.println(number);
		});
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> em Bloco Anônimo/Redução 3 (Java
	 * 1.8)
	 */
	private void fibonacciLambdaConsumerBlocoAnonimoReducao3() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach(number -> System.out.println(number));
	}

	/**
	 * Fibonacci com Lambda e Consumer<Integer> em Bloco Anônimo/Redução Extra
	 * (Java 1.8)
	 */
	private void fibonacciLambdaConsumerBlocoAnonimoReducaoExtra() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);

		numbers.forEach(System.out::println);
	}

}
