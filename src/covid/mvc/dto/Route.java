package covid.mvc.dto;

public class Route {
	private String district;//���̸�
    private String placeCode;//����ڵ� �� ����̸� ���
    private String userId;//ȯ�ھ��̵�
    private int patientNo;//ȯ�ڹ�ȣ
    private String visitDate;//�湮��¥
    
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
		builder.append("[ȯ�� ��ȣ]");
		builder.append(patientNo);
		builder.append(" | [�湮�� ��]");
		builder.append(district);
		builder.append(" | [�湮�� ���]");
		builder.append(placeCode);
		builder.append(" | [�湮 ��¥]");
		builder.append(visitDate);
		return builder.toString();
	}
    
	


}
