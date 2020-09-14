package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Route;

public interface PatientDAO {
	/**
	 * 주소 기반 병원 찾기
	 */
	public Hospital selectHospitalByAddr(String userAddr) throws SQLException;
	
	/**
	 * 병원 전체 출력
	 */
	public List<Hospital> selectHospitalAll()throws SQLException;
	
	/**
	 * 환자 집어넣기
	 */
	public void insertPatient(Patient patient) throws SQLException;
	
	/**
	 * 확진자 동선 입력
	 */
	public void insertRoute(Route route) throws SQLException;
	
	
}
