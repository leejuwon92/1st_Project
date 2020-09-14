package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Seoul;


public interface ClientsDAO {
	/**
	 * Clients �α���
	 */
	public Clients login(String userId, String userPwd) throws SQLException;
	
	/**
	 * �ּ� ������� ����ũ ��� �ִ� �౹ 
	 */
	public Drug selectMaskByAddr(String userAddr)throws SQLException;
	
	/**
	 * Ȯ���� ���� ��ȸ
	 */
	public List<Patient> selectRouteByAddr(String userAddr) throws SQLException;
	
	/**
	 * ����� ��ü Ȯ���� ��ȸ
	 */
	public List<Seoul> selectByAll() throws SQLException;
	
	
}	
