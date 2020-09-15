package covid.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Seoul;
import covid.mvc.util.DbUtil;

public class ClientsDAOImpl implements ClientsDAO {

	@Override
	public Clients login(String userId, String userPwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Clients clients = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				clients = new Clients(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return clients;
	}

	@Override
	public Drug selectMaskByAddr(String userAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Drug drugStore = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userAddr);
			rs = ps.executeQuery();
			if(rs.next()) {
				drugStore = new Drug(rs.getNString(1), rs.getString(2), rs.getInt(3));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return drugStore;
	}

	@Override
	public List<Patient> selectRouteByAddr(String addr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Patient> list = new ArrayList<Patient>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, addr);
			rs = ps.executeQuery();
			while(rs.next()) {
				Patient patient = new Patient(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				list.add(patient);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Seoul> selectByAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Seoul> list = new ArrayList<Seoul>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Seoul seoul = new Seoul(rs.getString(1), rs.getInt(2), rs.getString(3));
				list.add(seoul);
			}
			
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

}
