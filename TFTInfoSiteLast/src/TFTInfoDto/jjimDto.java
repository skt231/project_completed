package TFTInfoDto;

public class jjimDto {

	String name;
	String skill;
	int price;
	String synerge1;
	String synerge2;
	String synerge3;

	public jjimDto() {
	};

	public jjimDto(String name, String skill, int price, String synerge1, String synerge2, String synerge3) {
      super();
       this.name = name;
       this.skill = skill;
       this.price = price;
      this.synerge1 = synerge1;
      this.synerge2 = synerge2;
      this.synerge3 = synerge3;
   }

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

	public String getSynerge1() {
		return synerge1;
	}

	public void setSynerge1(String synerge1) {
		this.synerge1 = synerge1;
	}

	public String getSynerge2() {
		return synerge2;
	}

	public void setSynerge2(String synerge2) {
		this.synerge2 = synerge2;
	}

	public String getSynerge3() {
		return synerge3;
	}

	public void setSynerge3(String synerge3) {
		this.synerge3 = synerge3;
	}

	@Override
	public String toString() {
		return "JjimDto [name=" + name + ", skill=" + skill + ", price=" + price + ", synerge1=" + synerge1
				+ ", synerge2=" + synerge2 + ", synerge3=" + synerge3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((synerge1 == null) ? 0 : synerge1.hashCode());
		result = prime * result + ((synerge2 == null) ? 0 : synerge2.hashCode());
		result = prime * result + ((synerge3 == null) ? 0 : synerge3.hashCode());
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
		jjimDto other = (jjimDto) obj;
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
		if (synerge1 == null) {
			if (other.synerge1 != null)
				return false;
		} else if (!synerge1.equals(other.synerge1))
			return false;
		if (synerge2 == null) {
			if (other.synerge2 != null)
				return false;
		} else if (!synerge2.equals(other.synerge2))
			return false;
		if (synerge3 == null) {
			if (other.synerge3 != null)
				return false;
		} else if (!synerge3.equals(other.synerge3))
			return false;
		return true;
	}

}