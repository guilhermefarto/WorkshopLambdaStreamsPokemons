package workshop.vo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PokemonVO {

	private long id;
	private String name;
	private List<Type> type;
	private BigDecimal hp = new BigDecimal("100.0");
	private BigDecimal attack = BigDecimal.ZERO;
	private BigDecimal specialAttack = BigDecimal.ZERO;
	private BigDecimal defense = BigDecimal.ZERO;
	private BigDecimal specialDefense = BigDecimal.ZERO;
	private PokemonVO parent;
	private PokemonVO evolution;
	private boolean rare;

	public PokemonVO(long id, String name, Type... types) {
		super();
		this.id = id;
		this.name = name;

		if (types != null && types.length > 0) {
			this.type = Arrays.asList(types);
		} else {
			this.type = Arrays.asList(Type.UNKNOWN);
		}
	}

	public PokemonVO(long id, String name, BigDecimal attack, BigDecimal defense, Type... types) {
		this(id, name, types);
		this.attack = attack;
		this.defense = defense;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public BigDecimal getHp() {
		if (this.hp == null) {
			setHp(BigDecimal.ZERO);
		}

		return hp;
	}

	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}

	public void changeHp(BigDecimal hp) {
		setHp(getHp().add(hp));
	}

	public void heal() {
		restoreHp(new BigDecimal("100"));
	}

	public void restoreHp(BigDecimal hp) {
		setHp(hp);
	}

	public void changeAttack(BigDecimal attack) {
		setAttack(getAttack().add(attack));
	}

	public BigDecimal getAttack() {
		return attack;
	}

	public void setAttack(BigDecimal attack) {
		this.attack = attack;
	}

	public BigDecimal getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(BigDecimal specialAttack) {
		this.specialAttack = specialAttack;
	}

	public BigDecimal getDefense() {
		return defense;
	}

	public void setDefense(BigDecimal defense) {
		this.defense = defense;
	}

	public BigDecimal getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(BigDecimal specialDefense) {
		this.specialDefense = specialDefense;
	}

	public PokemonVO getParent() {
		return parent;
	}

	public void setParent(PokemonVO parent) {
		this.parent = parent;
	}

	public PokemonVO getEvolution() {
		return evolution;
	}

	public void setEvolution(PokemonVO evolution) {
		this.evolution = evolution;
	}

	public boolean isRare() {
		return rare;
	}

	public void setRare(boolean rare) {
		this.rare = rare;
	}

	public void makeEvolvableTo(PokemonVO pokemonEvolution) {
		this.setEvolution(pokemonEvolution);
		pokemonEvolution.setParent(this);
	}

	public boolean hasEvolution() {
		return this.evolution != null;
	}

	public boolean hasParent() {
		return this.parent != null;
	}

}
