package covid.mvc.dto;

public class Patient {
	private int patientNo; // Ȯ���� ��ȣ
	private String regDate; // Ȯ�� ��¥
	private int disState; // ��ġ ���� 1�̸� Ȯ���� 0 ��ġ
	private String userId; // Ŭ���̾�Ʈ ID
	private String hospitalCode; // ���� �ڵ�
	
	public Patient () {}
	

	public Patient(int patientNo, String regDate, int disState, String userId, String hospitalCode) {
		this.patientNo = patientNo;
		this.regDate = regDate;
		this.disState = disState;
		this.userId = userId;
		this.hospitalCode = hospitalCode;
	}


	public int getPatientNo() {
		return patientNo;
	}


	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getDisState() {
		return disState;
	}


	public void setDisState(int disState) {
		this.disState = disState;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getHospitalCode() {
		return hospitalCode;
	}


	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	
	@Override
	public String toString() {
		return patientNo+" | " + regDate;
	}
	
	
}
