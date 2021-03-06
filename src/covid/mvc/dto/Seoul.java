package covid.mvc.dto;

public class Seoul {
	private String district;//구이름
	private int dis_patient;//확진자수
	private String hazard;//위험도
	
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
		if(this.dis_patient < 20) {
			setHazard("저");
		} else if(dis_patient < 50) {
			setHazard("중");
		} else if(dis_patient < 100) {
			setHazard("고");
		}
		
		return "[확진자 발생구역] :"+district+" | "+"[확진자 수] :"+dis_patient+"[구역별 위험도] :"+hazard;
	}
	



}
