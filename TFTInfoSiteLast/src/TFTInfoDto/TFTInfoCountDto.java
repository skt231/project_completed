package TFTInfoDto;

public class TFTInfoCountDto {
	
	private String name;
	private Integer count;
	
	public TFTInfoCountDto() {}
	public TFTInfoCountDto(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "TFTInfoCountDto [name=" + name + ", count=" + count + "]";
	}
	
	

}
