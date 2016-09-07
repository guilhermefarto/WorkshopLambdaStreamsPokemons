package workshop.streams;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import workshop.bo.Pokedex;
import workshop.vo.PokemonTrainerVO;
import workshop.vo.PokemonVO;
import workshop.vo.Team;

public class MainStream {

	PokemonTrainerVO guilherme = new PokemonTrainerVO(1, "Guilherme", 1, Team.MYSTIC);

	public static void main(String[] args) {
		MainStream ms = new MainStream();

		System.out.println("Stream Max");
		ms.streamMax1();

		System.out.println("Stream Max e Comparator.comparing e ifPresent");
		ms.streamMax2();

		System.out.println("Stream Collect e Collectors.toList");
		ms.streamCollectList();

		System.out.println("Stream Collect e Collectors.toMap");
		ms.streamCollectMap();

		System.out.println("Stream Map-Reduce");
		ms.streamMapReduce();
	}

	/**
	 * Exemplo de operação terminal Max
	 */
	private void streamMax1() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		Optional<PokemonVO> pokemonMaiorAtaque = pokemons.stream().filter(PokemonVO::hasEvolution).max(Comparator.comparing(PokemonVO::getAttack));

		if (pokemonMaiorAtaque.isPresent()) {
			PokemonVO pokemon = pokemonMaiorAtaque.get();

			guilherme.evolvePokemon(pokemon);
		}
	}

	/**
	 * Exemplo de operação terminal Max e Comparator.comparing e ifPresent
	 */
	private void streamMax2() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Pokedex.printData(pokemons);

		pokemons.stream().filter(PokemonVO::hasEvolution).max(Comparator.comparing(PokemonVO::getAttack)).ifPresent(p -> guilherme.evolvePokemon(p));

		Pokedex.printData(pokemons);
	}

	/**
	 * Exemplo de operação terminal Collect e Collectors.toList
	 */
	private void streamCollectList() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		List<PokemonVO> pokemonsColetados = pokemons.stream().filter(p -> p.getHp().compareTo(new BigDecimal("50")) > 0).collect(Collectors.toList());
	}

	/**
	 * Exemplo de operação terminal Collect e Collectors.toMap
	 */
	private void streamCollectMap() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		Map<Long, PokemonVO> pokemonsColetados = pokemons.stream().filter(p -> p.getHp().compareTo(new BigDecimal("50")) > 0).collect(Collectors.toMap(PokemonVO::getId, p -> p));

		// .collect(Collectors.toMap(PokemonVO::getId, Function.identity()));
	}

	/**
	 * Exemplo de operação terminal Map-Reduce
	 */
	private void streamMapReduce() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		BigDecimal ataqueTotal = pokemons.stream().filter(PokemonVO::hasEvolution).map(PokemonVO::getAttack).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

		// .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
