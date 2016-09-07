package workshop.lambda;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import workshop.bo.Pokedex;
import workshop.vo.PokemonVO;

public class MainRemocao {

	public static void main(String[] args) {
		MainRemocao m = new MainRemocao();

		try {
			System.out.println("< Java 1.8");
			m.remocao1();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("List - < Java 1.8");
		m.remocao2();

		System.out.println("Iterator - <Java 1.8");
		m.remocao3();

		System.out.println("Lambda - Java 1.8");
		m.remocaoLambda();

		System.out.println("Lambda e Predicate.or - Java 1.8");
		m.remocaoLambdaExtra();
	}

	/**
	 * Remoção sem Lambda (< Java 1.8)
	 */
	private void remocao1() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		for (PokemonVO pokemon : pokemons) {
			if (!pokemon.hasEvolution()) {
				pokemons.remove(pokemon);
			}
		}

		Pokedex.printData(pokemons);
	}

	/**
	 * Remoção sem Lambda (< Java 1.8)
	 */
	private void remocao2() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		List<PokemonVO> pokemonsFiltrados = new LinkedList<PokemonVO>();

		Pokedex.printData(pokemons);

		for (PokemonVO pokemon : pokemons) {
			if (pokemon.hasEvolution()) {
				pokemonsFiltrados.add(pokemon);
			}
		}

		Pokedex.printData(pokemonsFiltrados);
	}

	/**
	 * Remoção sem Lambda (< Java 1.8)
	 */
	private void remocao3() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Iterator<PokemonVO> iPokemons = pokemons.iterator();

		Pokedex.printData(pokemons);

		while (iPokemons.hasNext()) {
			PokemonVO pokemon = iPokemons.next();

			if (!pokemon.hasEvolution()) {
				iPokemons.remove();
			}
		}

		Pokedex.printData(pokemons);
	}

	/**
	 * Remoção com Lambda (Java 1.8)
	 */
	private void remocaoLambda() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.removeIf(p -> !p.hasEvolution());

		Pokedex.printData(pokemons);
	}

	/**
	 * Remoção com Lambda Extra (Java 1.8)
	 */
	private void remocaoLambdaExtra() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Predicate<PokemonVO> naoPossuiEvolucao = p -> !p.hasEvolution();

		Predicate<PokemonVO> possuiAtaqueFraco = p -> p.getAttack().compareTo(new BigDecimal("30")) < 0;

		Pokedex.printData(pokemons);

		pokemons.removeIf(naoPossuiEvolucao.or(possuiAtaqueFraco));

		Pokedex.printData(pokemons);
	}

}
