package covid.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String hospitalCode;
	private int mediStaff;
	private String hospitalName;
	private int bedNo;
	private String hospitalAddr;
	private int patientCurr;
	private String userId;
	private List<Patient> list = new ArrayList<Patient>();

	public Hospital() {
	}

	public Hospital(String hospitalCode, int mediStaff, String hospitalName, int bedNo, String hospitalAddr,
			int patientCurr, String userId) {
		this.hospitalCode = hospitalCode;
		this.mediStaff = mediStaff;
		this.hospitalName = hospitalName;
		this.bedNo = bedNo;
		this.hospitalAddr = hospitalAddr;
		this.patientCurr = patientCurr;
		this.userId = userId;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public int getMediStaff() {
		return mediStaff;
	}

	public void setMediStaff(int mediStaff) {
		this.mediStaff = mediStaff;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getBedNo() {
		return bedNo;
	}

	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}

	public String getHospitalAddr() {
		return hospitalAddr;
	}

	public void setHospitalAddr(String hospitalAddr) {
		this.hospitalAddr = hospitalAddr;
	}

	public int getPatientCurr() {
		return patientCurr;
	}

	public void setPatientCurr(int patientCurr) {
		this.patientCurr = patientCurr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Patient> getList() {
		return list;
	}

	public void setList(List<Patient> list) {
		this.list = list;
	}


	/**
	 * 환자 입장에서 병원조회
	 * */
	public String patientHospital(){
		StringBuilder builder = new StringBuilder();
		builder.append("[병원 이름]");
		builder.append(hospitalName);
		builder.append(" | [현재 수용 가능 환자 수]");
		builder.append(bedNo);
		builder.append(" | [병원 주소]");
		builder.append(hospitalAddr);
		return builder.toString();	
	}
	/**
	 * 병원입장에서 자기 병원조회
	 * */
	public String hospitalHospital() {
		StringBuilder builder = new StringBuilder();
		builder.append("[병원 이름]");
		builder.append(hospitalName);
		builder.append(" | [현재 의료진 수]");
		builder.append(mediStaff);
		builder.append(" | [잔여 병상수]");
		builder.append(bedNo);
		builder.append(" | [현재 수용환자 수]");
		builder.append(patientCurr);
		return builder.toString();
	}

}
