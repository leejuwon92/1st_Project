package covid.mvc.dto;

public class Seoul {
	private String district;//���̸�
	private int dis_patient;//Ȯ���ڼ�
	private String hazard;//���赵
	
	public Seoul() {}

	public Seoul(String district, int dis_patient, String hazard) {
		super();
		this.district = district;
		this.dis_patient = dis_patient;
		this.hazard = hazard;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getDis_patient() {
		return dis_patient;
	}

	public void setDis_patient(int dis_patient) {
		this.dis_patient = dis_patient;
	}

	public String getHazard() {
		return hazard;
	}

	public void setHazard(String hazard) {
		this.hazard = hazard;
	}

	@Override
	public String toString() {
	
		
		return "[Ȯ���� �߻�����]:"+district+" | "+"[Ȯ���� ��]:"+dis_patient+"[������ ���赵]"+hazard;
	}
	
	@Override
	public String toString() {
		return "�� ���� ���� Ȯ���� �� " + getDis_patient() + "\n���赵" + getHazard();
	}



}
