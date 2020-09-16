package covid.mvc.dto;

public class Route {
	private String district;//구이름
    private String placeCode;//장소코드 겸 장소이름 겸용
    private String userId;//환자아이디
    private int patientNo;//환자번호
    private String visitDate;//방문날짜
    
    public Route() {}

	public Route(String district, String placeCode, String userId, int patientNo,String visitDate) {
		super();
		this.district = district;
		this.placeCode = placeCode;
		this.userId = userId;
		this.patientNo = patientNo;
		this.visitDate = visitDate;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[환자 번호]");
		builder.append(patientNo);
		builder.append(" | [방문한 구]");
		builder.append(district);
		builder.append(" | [방문한 장소]");
		builder.append(placeCode);
		builder.append(" | [방문 날짜]");
		builder.append(visitDate);
		return builder.toString();
	}
    
	


}
