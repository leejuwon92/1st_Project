package covid.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Place;
import covid.mvc.dto.Route;

public interface PatientDAO {
	/**
	 * �ּ� ��� ���� ã��
	 */
	public List<Hospital> selectHospitalByAddr(String userAddr) throws SQLException;
	
	/**
	 * ���� ��ü ���
	 */
	public List<Hospital> selectHospitalAll()throws SQLException;
	
	/**
	 * Ȯ���� ���� �Է�
	 */
	public int insertRoute(Route route) throws SQLException;
	
	/**
	 * ���� �̸����� �˻�
	 */
	public Hospital selectHospitalByName(String hospitalName, String sessionId) throws SQLException;
	
	/**
	 * ��� �ڵ� ���
	 */
	public List<Place> selectPlaceAll()throws SQLException;
	
	/**
	 * ȯ�� ���� ����
	 */
	public int updateHospitalCode(Connection con, String userId, String hospitalAddr) throws SQLException;

	/**
	 * ȯ�ڰ� �������ý� �������̺� ȯ�ڼ��� ����
	 * */
	public int updatePatientCurr(Connection con,String hospitalCode)throws SQLException;
}
