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
		String sql = "select hospital_code, medi_staff, hospital_name, ((medi_staff * 2) - patient_curr), "
				+ "patient_curr,clients_id from hospital where clients_id = ?";
		Hospital hospital = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				hospital = new Hospital(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						null, rs.getInt(5), rs.getString(6));
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
		String sql = "select patient_no, regdate from patient join hospital on patient.hospital_code=hospital.hospital_code "
				+ "where hospital.clients_id=? and dis_state != 0 order by patient_no";
		List<Patient> list = new ArrayList<Patient>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
					Patient patient = new Patient(rs.getInt(1), rs.getString(2), 0, null, null);
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
		String sql = "update patient set dis_state=0 where patient_no=?";
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
			int result1=updatePatientToClients(con, patientNo);
			int result2=updateHospitalPatientCurr(con,patientNo);
			if(result1==0||result2==0) {
				con.rollback();
			}
		} finally {
			con.commit();
			DbUtil.close(con, ps, null);
		}
		return result;
	}
	
	@Override
	public int updatePatientToClients(Connection con,int patientNo) throws SQLException {
		PreparedStatement ps=null;
		String  sql="update clients set clients_type=1 where clients_type=(select clients_id from patient where patient_no=?";
		int result=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(sql);
			ps.setInt(1, patientNo);
			result=ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("수정 실패");
			}
			
		}finally {
			con.commit();
			DbUtil.close(null, ps, null);
		}
		return result;
	}

	@Override
	public int updateHospitalPatientCurr(Connection con, int patientNo) throws SQLException {
		PreparedStatement ps=null;
		String sql="update hospital set patient_curr=patient_curr-1"
				+ " where hospital_code=(select hospital_code from patient where patient_no=?";
		int result=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(sql);
			ps.setInt(1, patientNo);
			result=ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("수정 실패");
			}
		}finally {
			con.commit();
			DbUtil.close(null, ps,null);
		}
		return result;
	}
	
	

	@Override
	public int updateMediStaff(String userId, int mediStaff) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update hospital set medi_staff=? where clients_id=?";
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
		String sql = "insert into hospital values(?,?,?,?,?,?,?)";
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
			ps.setInt(6, hospital.getPatientCurr());
			ps.setString(7, hospital.getUserId());
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("병원 회원가입에 실패하였습니다.");
			}
		} finally {
			con.commit();
			DbUtil.close(con, ps, null);
		}
		return result;
	}

	

	
}
