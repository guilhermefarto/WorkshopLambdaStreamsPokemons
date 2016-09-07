package workshop.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import workshop.bo.Pokedex;
import workshop.vo.PokemonVO;

public class MainOrdenacaoComparacaoLambda {

	public static void main(String[] args) {
		MainOrdenacaoComparacaoLambda mocl = new MainOrdenacaoComparacaoLambda();

		System.out.println("< Java 1.8");
		mocl.ordenacaoComparacao1();

		System.out.println("Lambda - Java 1.8");
		mocl.ordenacaoComparacaoLambda();
	}

	/**
	 * Ordenação/Comparação sem Lambda (< Java 1.8)
	 */
	private void ordenacaoComparacao1() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		Collections.sort(pokemons, new Comparator<PokemonVO>() {

			@Override
			public int compare(PokemonVO p1, PokemonVO p2) {
				return p1.getHp().compareTo(p2.getHp());
			}
		});

		Pokedex.printData(pokemons);
	}

	/**
	 * Ordenação/Comparação com Lambda (Java 1.8)
	 */
	private void ordenacaoComparacaoLambda() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.sort((p1, p2) -> p1.getHp().compareTo(p2.getHp()));

		Pokedex.printData(pokemons);
	}

}
