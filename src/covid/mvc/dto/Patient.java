package covid.mvc.dto;

public class Patient {
	private int patientNo; // 확진자 번호
	private String regDate; // 확진 날짜
	private int disState; // 완치 여부 1이면 확진자 0 완치
	private String userId; // 클라이언트 ID
	private String hospitalCode; // 병원 코드
	
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
