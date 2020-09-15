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
	 * ȯ�� ����ֱ�
	 */
	public int insertPatient(Connection con, Patient patient) throws SQLException;
	
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
}
