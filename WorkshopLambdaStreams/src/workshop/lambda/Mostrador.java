package workshop.lambda;

import java.util.function.Consumer;

public class Mostrador implements Consumer<Integer> {

	@Override
	public void accept(Integer number) {
		System.out.println(number);
	}

}
