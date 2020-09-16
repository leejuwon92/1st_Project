package covid.mvc.dto;

public class Place {
	private String placeCode;//����ڵ�
    private String placeType;//���Ÿ��
    
    public Place() {}

	public Place(String placeCode, String placeType) {
		super();
		this.placeCode = placeCode;
		this.placeType = placeType;
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[��� �̸�]");
		builder.append(placeType);
		builder.append(" | [��� �ڵ�]");
		builder.append(placeCode);
		return builder.toString();
	}
    
    


}
