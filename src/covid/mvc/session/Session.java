package covid.mvc.session;

import covid.mvc.dto.Seoul;

public class Session {
	private String sessionId;
	private String sessionAddr;
	private int sessionType;
	private Seoul seoul;

	public Session() {
	}

	public Session(String sessionId, String sessionAddr, int sessionType) {
		this.sessionId = sessionId;
		this.sessionAddr = sessionAddr;
		this.sessionType = sessionType;
		Seoul seoul = new Seoul();
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionAddr() {
		return sessionAddr;
	}

	public void setSessionAddr(String sessionAddr) {
		this.sessionAddr = sessionAddr;
	}

	public int getSessionType() {
		return sessionType;
	}

	public void setSessionType(int sessionType) {
		this.sessionType = sessionType;
	}

	public Seoul getSeoul() {
		return seoul;
	}

	public void setSeoul(Seoul seoul) {
		this.seoul = seoul;
	}

	@Override
	public int hashCode() {
		return sessionId.hashCode();
	}

	@Override
	public String toString() {
		return "내 동네 현재 확진자 수 " + seoul.getDis_patient() + "\n위험도" + seoul.getHazard();
	}

	@Override
	public boolean equals(Object obj) {
		Session other = (Session) obj;
		if (sessionId.equals(other.sessionId)) {
			return true;
		} else {
			return false;
		}

	}

}
