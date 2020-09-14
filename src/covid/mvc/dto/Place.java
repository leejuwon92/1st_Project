package covid.mvc.dto;

public class Place {
	private String placeCode;//장소코드
    private String placeType;//장소타입
    
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
    
    


}
