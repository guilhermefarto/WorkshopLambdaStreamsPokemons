package workshop.vo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import workshop.fi.PokemonStats;

public class PokemonTrainerVO {

	private long id;
	private String name;
	private String sex;
	private long level;
	private Team team;
	private List<PokemonVO> pokemons;

	public PokemonTrainerVO(long id, String name, long level, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.team = team;
	}

	public long getId() {
		return id;
	}

	public boolean isMale() {
		return "M".equalsIgnoreCase(this.sex);
	}

	public boolean isFemale() {
		return !isMale();
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getLevel() {
		return level;
	}

	public void increaseLevel() {
		this.level++;
	}

	public void decreaseLevel() {
		this.level--;
	}

	public boolean isInstinctTeam() {
		return Team.INSTINCT.equals(this.team);
	}

	public boolean isMysticTeam() {
		return Team.MYSTIC.equals(this.team);
	}

	public boolean isValorTeam() {
		return Team.VALOR.equals(this.team);
	}

	public boolean hasPokemons() {
		return pokemons != null && !pokemons.isEmpty();
	}

	public List<PokemonVO> getPokemons() {
		if (pokemons == null) {
			pokemons = new LinkedList<PokemonVO>();
		}

		return pokemons;
	}

	public void capturePokemon(PokemonVO pokemon) {
		getPokemons().add(pokemon);

		System.out.println(this.getName() + " caught " + pokemon.getName() + ".");
	}

	public PokemonVO evolvePokemon(PokemonVO pokemon) {
		if (pokemon.hasEvolution()) {
			System.out.println(pokemon.getName() + " evolved to " + pokemon.getEvolution().getName() + ".");

			pokemon.changeAttack(new BigDecimal("10"));

			return pokemon.getEvolution();
		} else {
			System.out.println(pokemon.getName() + " can't be evolved.");
		}

		return null;
	}

	public void verifyPokedex() {
		if (hasPokemons()) {
			System.out.println(this.getName() + " has " + getPokemons().size() + " Pokémons: ");

			for (PokemonVO pokemon : getPokemons()) {
				System.out.println("  " + pokemon.getName() + " (" + pokemon.getHp() + " HP | " + pokemon.getAttack() + " ATK | " + pokemon.getDefense() + " DEF | " + pokemon.getSpecialAttack() + " SATK | " + pokemon.getSpecialDefense() + " SDEF)");
			}
		} else {
			System.out.println(this.getName() + " has no Pokémons.");
		}
	}

	public void powerUp(PokemonVO pokemon, BigDecimal value, PokemonStats ps) {
		ps.powerUp(pokemon, value);
	}

}
