package covid.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Route;
import covid.mvc.util.DbUtil;

public class PatientDAOImpl implements PatientDAO {

	@Override
	public Hospital selectHospitalByAddr(String userAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		Hospital hospital = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userAddr);
			rs = ps.executeQuery();
			if(rs.next()) {
				hospital = new Hospital(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return hospital;
	}

	@Override
	public List<Hospital> selectHospitalAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		List<Hospital> list = new ArrayList<Hospital>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Hospital hospital = new Hospital(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7));
				list.add(hospital);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insertPatient(Patient patient) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result=0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("등록 실패");
			}
		} finally {
			DbUtil.close(con, ps, null);
		}
		return result;
	}

	@Override
	public int insertRoute(Route route) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result=0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("동선 등록 실패");
			}
		} finally {
			DbUtil.close(con, ps, null);
		}
		return result;
	}
}
