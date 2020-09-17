package covid.mvc.dao;

import java.sql.Connection;
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
	 * 병원 현재 현황 출력
	 */
	public Hospital selectHospital(String userId)throws SQLException;
		
	/**
	 * 환자 조회하기
	 */
	public List<Patient> selectByPatient(String userId) throws SQLException;
	
	/**
	 * 완치 여부 변경
	 */
	public int updatePatient(int patientNo)throws SQLException;
	
	/**
	 * 완치 환자 일반인환자타입으로 변경
	 * */
	public int updatePatientToClients (Connection con,int patientNo)throws SQLException;
	
	/**
	 * 의료진 숫자 변경
	 */
	public int updateMediStaff(String userId, int mediStaff)throws SQLException;
	
	/**
	 * 병원 회원가입
	 */
	public int insertHospital(Hospital hospital) throws SQLException;
}
