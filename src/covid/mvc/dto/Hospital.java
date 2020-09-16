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
	 * ȯ�� ���忡�� ������ȸ
	 * */
	public String patientHospital(){
		StringBuilder builder = new StringBuilder();
		builder.append("[���� �̸�]");
		builder.append(hospitalName);
		builder.append(" | [���� ���� ���� ȯ�� ��]");
		builder.append(bedNo);
		builder.append(" | [���� �ּ�]");
		builder.append(hospitalAddr);
		return builder.toString();	
	}
	/**
	 * �������忡�� �ڱ� ������ȸ
	 * */
	public String hospitalHospital() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���� �̸�]");
		builder.append(hospitalName);
		builder.append(" | [���� �Ƿ��� ��]");
		builder.append(mediStaff);
		builder.append(" | [�ܿ� �����]");
		builder.append(bedNo);
		builder.append(" | [���� ����ȯ�� ��]");
		builder.append(patientCurr);
		return builder.toString();
	}

}
