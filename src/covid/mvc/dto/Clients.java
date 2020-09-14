package covid.mvc.dto;

public class Clients {
	private String userId; 
	private String userPwd;
	private int userType;
	private String userAddr;
	
	public Clients() {}
	
	public Clients(String userId, String userPwd, int userType, String userAddr) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userType = userType;
		this.userAddr = userAddr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	
	
	
}
