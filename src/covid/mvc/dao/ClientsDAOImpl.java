package covid.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Seoul;

public class ClientsDAOImpl implements ClientsDAO {
	private Connection con = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;

	@Override
	public Clients login(String userId, String userPwd) throws SQLException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drug selectMaskByAddr(String userAddr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> selectRouteByAddr(String userAddr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seoul> selectByAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
