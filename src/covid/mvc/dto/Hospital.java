package covid.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String hospitalCode;
	private int mediStaff;
	private String hospitalName;
	private int bedNo;
	private String hospitalAddr;
	private int patient_curr;
	private String userId;
	private List<Patient> list = new ArrayList<Patient>();

	public Hospital() {
	}

	public Hospital(String hospitalCode, int mediStaff, String hospitalName, int bedNo, String hospitalAddr,
			int patient_curr, String userId) {
		this.hospitalCode = hospitalCode;
		this.mediStaff = mediStaff;
		this.hospitalName = hospitalName;
		this.bedNo = bedNo;
		this.hospitalAddr = hospitalAddr;
		this.patient_curr = patient_curr;
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

	public int getPatient_curr() {
		return patient_curr;
	}

	public void setPatient_curr(int patient_curr) {
		this.patient_curr = patient_curr;
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

}
