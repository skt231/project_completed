package TFTInfoDto;

public class ChampionSynergeDto {

	private String name;
	private String skill; 
	private int price;
	TFTInfoSynergeDto synerge;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public TFTInfoSynergeDto getSynerge() {
		return synerge;
	}
	public void setSynerge(TFTInfoSynergeDto synerge) {
		this.synerge = synerge;
	}	
	
	public ChampionSynergeDto() {}
	public ChampionSynergeDto(String name, String skill, int price, TFTInfoSynergeDto synerge) {
		super();
		this.name = name;
		this.skill = skill;
		this.price = price;
		this.synerge = synerge;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((synerge == null) ? 0 : synerge.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChampionSynergeDto other = (ChampionSynergeDto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (synerge == null) {
			if (other.synerge != null)
				return false;
		} else if (!synerge.equals(other.synerge))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "ChampionSynergeDto [name=" + name + ", skill=" + skill + ", price=" + price + ", synerge=" + synerge
				+ "]";
	}
	
	
}