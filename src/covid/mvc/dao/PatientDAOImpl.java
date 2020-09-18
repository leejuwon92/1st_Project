package covid.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Place;
import covid.mvc.dto.Route;
import covid.mvc.util.DbUtil;

public class PatientDAOImpl implements PatientDAO {

	@Override
	public List<Hospital> selectHospitalByAddr(String userAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select hospital_name, hospital_addr,(medi_staff*2)-patient_curr as 잔여병상수 from hospital where hospital_addr like ?";
		List<Hospital> list = new ArrayList<Hospital>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "'%"+userAddr+"%'");
			rs = ps.executeQuery();
			while(rs.next()) {
				Hospital hospital = new Hospital(null, 0, rs.getString(1), rs.getInt(3),
						rs.getString(2), 0, null);
				list.add(hospital);
			}
		} finally {
			
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Hospital> selectHospitalAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select hospital_name, hospital_addr,(medi_staff*2)-patient_curr as 잔여병상수 from hospital;";
		List<Hospital> list = new ArrayList<Hospital>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Hospital hospital = new Hospital(null, 0, rs.getString(1), rs.getInt(3),
						rs.getString(2), 0, null);
				list.add(hospital);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insertRoute(Route route) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into route values(?,?, (select patient_no from patient where clients_id = ? ),?)";
		int result=0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, route.getDistrict());
			ps.setString(2,route.getPlaceCode());
			ps.setString(3,route.getUserId());
			ps.setString(4,route.getVisitDate());
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
	
	@Override
	public Hospital selectHospitalByName(String hospitalName, String sessionId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from Hospital where Hospital_name =?";
		Hospital hospital = null;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, hospitalName);
			rs = ps.executeQuery();
			if(rs.next()) {
				hospital = new Hospital(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7));
				if(hospital != null) {
					int result1 = updateHospitalCode(con, sessionId, hospital.getHospitalCode());
					int result2= updatePatientCurr(con,hospital.getHospitalCode());
					if(result1 == 0 || result2==0) {
						con.rollback();
					}
					
				}
			}
			
		} finally {
			con.commit();
			DbUtil.close(con, ps, rs);
		}
		return hospital;
	}
	
	@Override
	public List<Place> selectPlaceAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from place";

		List<Place> list = new ArrayList<Place>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Place place = new Place(rs.getString(1), rs.getString(2));
				list.add(place);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public int updateHospitalCode(Connection con, String userId, String hospitalCode) throws SQLException {
		PreparedStatement ps = null;
		String sql = "update patient set hospital_code = ? where clients_id = ?";
		int result = 0;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, hospitalCode);
			ps.setString(2, userId);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
			}
		} finally {
			con.commit();
			DbUtil.close(null, ps, null);
		}
		return result;
	}

	@Override
	public int updatePatientCurr(Connection con, String hospitalCode) throws SQLException {
		PreparedStatement ps=null;
		String sql="update hospital set hospital_curr=hospital_curr+1 where hospital_code=?";
		int result=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(sql);
			ps.setString(1, hospitalCode);
			result=ps.executeUpdate();
			if(result == 0) {
				con.rollback();
			}
		}finally {
			con.commit();
			DbUtil.close(null, ps, null);
		}
		return result;
	}
	
}
