package covid.mvc.dto;

public class Drug {
	private String dName;//�౹�̸�
	private String dAddr;//�౹�ּ�
	private int maskNum;//����ũ����

	public Drug() {}

	public Drug(String dName, String dAddr, int maskNum) {
		super();
		this.dName = dName;
		this.dAddr = dAddr;
		this.maskNum = maskNum;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdAddr() {
		return dAddr;
	}

	public void setdAddr(String dAddr) {
		this.dAddr = dAddr;
	}

	public int getMaskNum() {
		return maskNum;
	}

	public void setMaskNum(int maskNum) {
		this.maskNum = maskNum;
	}

}
