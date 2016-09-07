package workshop.bo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import workshop.vo.PokemonVO;
import workshop.vo.Type;

public abstract class Pokedex {

	private static final BigDecimal NORMAL = new BigDecimal("25.0");
	private static final BigDecimal HIGH = new BigDecimal("36.5");
	private static final BigDecimal HIGHER = new BigDecimal("41.2");

	public static final PokemonVO BULBASAUR = new PokemonVO(1, "Bulbasaur", NORMAL, NORMAL, Type.POISON, Type.GRASS);
	public static final PokemonVO IVYSAUR = new PokemonVO(2, "Ivysaur", HIGH, NORMAL, Type.POISON, Type.GRASS);
	public static final PokemonVO VENUSAUR = new PokemonVO(3, "Venusaur", HIGHER, HIGH, Type.POISON, Type.GRASS);

	public static final PokemonVO CHARMANDER = new PokemonVO(4, "Charmander", NORMAL, NORMAL, Type.FIRE);
	public static final PokemonVO CHARMELEON = new PokemonVO(5, "Charmeleon", HIGH, NORMAL, Type.FIRE);
	public static final PokemonVO CHARIZARD = new PokemonVO(6, "Charizard", HIGHER, HIGH, Type.FIRE);

	public static List<PokemonVO> getPokemons() {
		List<PokemonVO> pokemons = new LinkedList<PokemonVO>();

		BULBASAUR.makeEvolvableTo(IVYSAUR);
		IVYSAUR.makeEvolvableTo(VENUSAUR);

		CHARMANDER.makeEvolvableTo(CHARMELEON);
		CHARMELEON.makeEvolvableTo(CHARIZARD);

		pokemons.add(BULBASAUR);
		pokemons.add(IVYSAUR);
		pokemons.add(VENUSAUR);

		pokemons.add(CHARMANDER);
		pokemons.add(CHARMELEON);
		pokemons.add(CHARIZARD);

		return pokemons;
	}

	public static void printData(List<PokemonVO> pokemons) {
		if (pokemons != null && !pokemons.isEmpty()) {
			for (int i = 0; i < pokemons.size(); i++) {
				PokemonVO pokemon = pokemons.get(i);

				if (i > 0) {
					System.out.print(" , ");
				}

				System.out.print(pokemon.getName() + " |" + pokemon.getHp() + " " + pokemon.getAttack() + " " + pokemon.getDefense() + "|");
			}

			System.out.println();
		}
	}

}
