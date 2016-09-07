package workshop.lambda;

import java.util.Comparator;
import java.util.List;
import workshop.bo.Pokedex;
import workshop.vo.PokemonVO;

public class MainOrdenacaoComparacaoMethodReference {

	public static void main(String[] args) {
		MainOrdenacaoComparacaoMethodReference mocmm = new MainOrdenacaoComparacaoMethodReference();

		System.out.println("Lambda e Method Reference (Comparator.comparing) - Java 1.8");
		mocmm.ordenacaoComparacaoLambdaMethodReference1();

		System.out.println("Lambda e Method Reference (Comparator.comparing e Reverse) - Java 1.8");
		mocmm.ordenacaoComparacaoLambdaMethodReference2();

		System.out.println("Lambda e Method Reference (Comparator.comparing e Comparator.thenComparing) - Java 1.8");
		mocmm.ordenacaoComparacaoLambdaMethodReference3();
	}

	/**
	 * Ordenação/Comparação com Lambda e Method Reference (Comparator.comparing)
	 * (Java 1.8)
	 */
	private void ordenacaoComparacaoLambdaMethodReference1() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.sort(Comparator.comparing(PokemonVO::getHp));

		Pokedex.printData(pokemons);
	}

	/**
	 * Ordenação/Comparação com Lambda e Method Reference (Comparator.comparing)
	 * (Java 1.8)
	 */
	private void ordenacaoComparacaoLambdaMethodReference2() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.sort(Comparator.comparing(PokemonVO::getHp).reversed());

		Pokedex.printData(pokemons);
	}

	/**
	 * Ordenação/Comparação com Lambda e Method Reference (Comparator.comparing)
	 * (Java 1.8)
	 */
	private void ordenacaoComparacaoLambdaMethodReference3() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.sort(Comparator.comparing(PokemonVO::getHp).thenComparing(PokemonVO::getName));

		Pokedex.printData(pokemons);
	}

}
