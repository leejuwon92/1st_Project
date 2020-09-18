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
	 * 주소 기반 병원 찾기
	 */
	public List<Hospital> selectHospitalByAddr(String userAddr) throws SQLException;
	
	/**
	 * 병원 전체 출력
	 */
	public List<Hospital> selectHospitalAll()throws SQLException;
	
	/**
	 * 확진자 동선 입력
	 */
	public int insertRoute(Route route) throws SQLException;
	
	/**
	 * 병원 이름으로 검색
	 */
	public Hospital selectHospitalByName(String hospitalName, String sessionId) throws SQLException;
	
	/**
	 * 장소 코드 출력
	 */
	public List<Place> selectPlaceAll()throws SQLException;
	
	/**
	 * 환자 병원 수정
	 */
	public int updateHospitalCode(Connection con, String userId, String hospitalAddr) throws SQLException;

	/**
	 * 환자가 병원선택시 병원테이블 환자숫자 증가
	 * */
	public int updatePatientCurr(Connection con,String hospitalCode)throws SQLException;
}
