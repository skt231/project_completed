package TFTInfoDto;

public class MemberDto {
	public MemberDto() {};
	private String ID;
	private String PW;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	@Override
	public String toString() {
		return "listDto [ID=" + ID + ", PW=" + PW + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((PW == null) ? 0 : PW.hashCode());
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
		MemberDto other = (MemberDto) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (PW == null) {
			if (other.PW != null)
				return false;
		} else if (!PW.equals(other.PW))
			return false;
		return true;
	}
	public MemberDto(String iD, String pW) {
		super();
		ID = iD;
		PW = pW;
	}
 
	
	
}
