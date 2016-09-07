package workshop.streams;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import workshop.bo.Pokedex;
import workshop.vo.PokemonTrainerVO;
import workshop.vo.PokemonVO;
import workshop.vo.Team;

public class MainIntroStream {

	PokemonTrainerVO guilherme = new PokemonTrainerVO(1, "Guilherme", 1, Team.MYSTIC);

	public static void main(String[] args) {
		MainIntroStream mis = new MainIntroStream();

		System.out.println("Filtrar (hasEvolucao), Ordenar (HP decresc.) e Executar (evolvePokemon)");
		mis.filtrarOrdenarExecutarPokemons();

		System.out.println("###");

		System.out.println("Filtrar (hasEvolucao), Ordenar (HP decresc.) e Executar (evolvePokemon) com Stream - Java 1.8");
		mis.filtrarOrdenarExecutarPokemonsStream();
	}

	/**
	 * Método para filtrar uma lista de PokemonVO com objetos que hasEvolution()
	 * = true, ordenar decrescentemente por valor de HP e invocar o método
	 * PokemonTrainerVO::evolvePokemon para a lista/coleção recuperada
	 */
	private void filtrarOrdenarExecutarPokemons() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		pokemons.forEach(PokemonVO::heal);
		pokemons.forEach(p -> p.setAttack(new BigDecimal("100")));

		pokemons.get(0).changeHp(new BigDecimal("-10"));
		pokemons.get(1).changeHp(new BigDecimal("30"));
		pokemons.get(2).changeHp(new BigDecimal("-15.7"));
		pokemons.get(3).changeHp(new BigDecimal("20"));
		pokemons.get(4).changeHp(new BigDecimal("-3.5"));
		pokemons.get(5).changeHp(new BigDecimal("16.8"));

		Pokedex.printData(pokemons);

		// Filtrar (hasEvolucao)

		List<PokemonVO> pokemonsFiltrados = new LinkedList<PokemonVO>();

		for (PokemonVO pokemon : pokemons) {
			if (pokemon.hasEvolution()) {
				pokemonsFiltrados.add(pokemon);
			}
		}

		Pokedex.printData(pokemonsFiltrados);

		// Ordenar (HP decresc.)

		Collections.sort(pokemonsFiltrados, new Comparator<PokemonVO>() {

			@Override
			public int compare(PokemonVO p1, PokemonVO p2) {
				return p1.getHp().compareTo(p2.getHp());
			}
		});

		Collections.reverse(pokemonsFiltrados);

		Pokedex.printData(pokemonsFiltrados);

		// Executar (evolvePokemon)

		for (PokemonVO pokemon : pokemonsFiltrados) {
			guilherme.evolvePokemon(pokemon);
		}

		Pokedex.printData(pokemonsFiltrados);
	}

	/**
	 * Método para filtrar uma lista de PokemonVO com objetos que hasEvolution()
	 * = true, ordenar decrescentemente por valor de HP e invocar o método
	 * PokemonTrainerVO::evolvePokemon para a lista/coleção recuperada
	 * utilizando recursos de Lambda + Default Method + Functional Interface
	 * + Method Reference + Stream
	 */
	private void filtrarOrdenarExecutarPokemonsStream() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		pokemons.forEach(PokemonVO::heal);
		pokemons.forEach(p -> p.setAttack(new BigDecimal("100")));

		pokemons.get(0).changeHp(new BigDecimal("-10"));
		pokemons.get(1).changeHp(new BigDecimal("30"));
		pokemons.get(2).changeHp(new BigDecimal("-15.7"));
		pokemons.get(3).changeHp(new BigDecimal("20"));
		pokemons.get(4).changeHp(new BigDecimal("-3.5"));
		pokemons.get(5).changeHp(new BigDecimal("16.8"));

		Pokedex.printData(pokemons);

		pokemons.stream().filter(PokemonVO::hasEvolution).sorted(Comparator.comparing(PokemonVO::getHp).reversed()).forEach(p -> guilherme.evolvePokemon(p));

		Pokedex.printData(pokemons);
	}

}
