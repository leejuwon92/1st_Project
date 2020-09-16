package covid.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.util.DbUtil;

public class HospitalDAOImpl implements HospitalDAO {
	@Override
	public Hospital selectHospital(String userId) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		Hospital hospital = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
	public List<Patient> selectByPatient(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		List<Patient> list = new ArrayList<Patient>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
	public int updatePatient(int patientNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, patientNo);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("수정 실패");
			}
		} finally {
			DbUtil.close(con, ps, null);
		}
		return result;
	}

	@Override
	public int updateMediStaff(String userId, int mediStaff) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, mediStaff);
			ps.setString(2, userId);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("수정 실패");
			}
		} finally {
			DbUtil.close(con, ps, null);
		}
		return result;
	}
	
	@Override
	public int insertHospital(Hospital hospital) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, hospital.getHospitalCode());
			ps.setInt(2, hospital.getMediStaff());
			ps.setString(3, hospital.getHospitalName());
			ps.setInt(4, hospital.getBedNo());
			ps.setString(5, hospital.getHospitalAddr());
			ps.setInt(6, hospital.getPatient_curr());
			ps.setString(7, hospital.getUserId());
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("병원 회원가입에 실패하였습니다.");
			}
		} finally {
			DbUtil.close(con, ps, null);
			con.commit();
		}
		return result;
	}

}
