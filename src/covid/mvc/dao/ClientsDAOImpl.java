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
import covid.mvc.dto.Route;
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
	public List<Drug> selectMaskByAddr(String userAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Drug> list = new ArrayList<Drug>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userAddr);
			rs = ps.executeQuery();
			if(rs.next()) {
				Drug drug = new Drug(rs.getNString(1), rs.getString(2), rs.getInt(3));
				list.add(drug);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Route> selectRouteByAddr(String addr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Route> list = new ArrayList<Route>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, addr);
			rs = ps.executeQuery();
			while(rs.next()) {
				Route route = new Route(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(route);
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
	
	@Override
	public Seoul selectSeoulByAddr(String addr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		Seoul seoul = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, addr);
			rs = ps.executeQuery();
			if(rs.next()) {
				seoul = new Seoul(rs.getString(1), rs.getInt(2), rs.getString(3));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return seoul;
	}
	
	@Override
	public int insertClients(Clients clients) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, clients.getUserId());
			ps.setString(2, clients.getUserPwd());
			ps.setInt(3, clients.getUserType());
			ps.setString(4, clients.getUserAddr());
			result = ps.executeUpdate();
			if(result==0) {
				throw new SQLException("회원가입에 실패했습니다");
			}
		} finally {
			DbUtil.close(con, ps, null);
		}
		return result;
	}
}
