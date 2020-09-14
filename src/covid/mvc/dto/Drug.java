package covid.mvc.dto;

public class Drug {
	private String dName;//약국이름
	private String dAddr;//약국주소
	private int maskNum;//마스크개수

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
