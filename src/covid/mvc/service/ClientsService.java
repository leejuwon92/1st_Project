package covid.mvc.service;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dao.ClientsDAO;
import covid.mvc.dao.ClientsDAOImpl;
import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Seoul;

public class ClientsService {
	ClientsDAO clientsDAO = new ClientsDAOImpl();
	
	public Clients login(String userId, String userPwd) throws SQLException {
		Clients clients = clientsDAO.login(userId, userPwd);
		if(clients == null) {
			throw new SQLException("아이디/비밀번호가 틀립니다. 정보를 다시 확인해주세요.");
		}
		return clients;
	}
	
	public Drug selectMaskByAddr(String addr) throws SQLException{
		Drug drug = clientsDAO.selectMaskByAddr(addr);
		if(drug == null) {
			throw new SQLException("주소를 찾을수 없습니다.");
		}
		return drug;
	}
	
	public List<Patient> selectRouteByAddr(String addr) throws SQLException{
		List<Patient> list = clientsDAO.selectRouteByAddr(addr);
		if(list == null) {
			throw new SQLException("주소를 찾을수 없습니다.");
		}
		return list;
	}
	
	public List<Seoul> selectByAll() throws SQLException{
		List<Seoul> list = clientsDAO.selectByAll();
		if(list == null) {
			throw new SQLException("정보를 찾을수 없습니다");
		}
		return list;
	}
}
