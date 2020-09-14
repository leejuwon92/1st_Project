package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Route;

public interface PatientDAO {
	/**
	 * �ּ� ��� ���� ã��
	 */
	public Hospital selectHospitalByAddr(String userAddr) throws SQLException;
	
	/**
	 * ���� ��ü ���
	 */
	public List<Hospital> selectHospitalAll()throws SQLException;
	
	/**
	 * ȯ�� ����ֱ�
	 */
	public void insertPatient(Patient patient) throws SQLException;
	
	/**
	 * Ȯ���� ���� �Է�
	 */
	public void insertRoute(Route route) throws SQLException;
	
	
}
