package covid.mvc.dto;

public class Route {
	private String district;//���̸�
    private String placeCode;//����ڵ�
    private int patientNo;//ȯ�ڹ�ȣ
    private String visitDate;//�湮��¥
    
    public Route() {}

	public Route(String district, String placeCode, int patientNo, String visitDate) {
		super();
		this.district = district;
		this.placeCode = placeCode;
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
    
	


}
