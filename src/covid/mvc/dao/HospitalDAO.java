package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;

public interface HospitalDAO {
	/*-- select_hospital
	-- select_by_patient	
	-- update_patient	
		-- select_by_patient
	update_madical_staff
	
	
	/**
	 * ���� ���� ��Ȳ ���
	 */
	public Hospital selectHospital(String userId)throws SQLException;
		
	/**
	 * ȯ�� ��ȸ�ϱ�
	 */
	public List<Patient> selectByPatient(String userId) throws SQLException;
	
	/**
	 * ��ġ ���� ����
	 */
	public int updatePatient(int patientNo)throws SQLException;
	
	/**
	 * �Ƿ��� ���� ����
	 */
	public int updateMediStaff(int mediStaff)throws SQLException;
}
