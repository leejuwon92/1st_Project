package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Seoul;


public interface ClientsDAO {
	/**
	 * Clients 로그인
	 */
	public Clients login(String userId, String userPwd) throws SQLException;
	
	/**
	 * 주소 기반으로 마스크 재고가 있는 약국 
	 */
	public Drug selectMaskByAddr(String userAddr)throws SQLException;
	
	/**
	 * 확진자 동선 조회
	 */
	public List<Patient> selectRouteByAddr(String userAddr) throws SQLException;
	
	/**
	 * 서울시 전체 확진자 조회
	 */
	public List<Seoul> selectByAll() throws SQLException;
	
	
}	
