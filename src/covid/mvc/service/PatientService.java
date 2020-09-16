package covid.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import covid.mvc.dao.PatientDAO;
import covid.mvc.dao.PatientDAOImpl;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Place;
import covid.mvc.dto.Route;

public class PatientService {
	PatientDAO patientDAO = new PatientDAOImpl();
	
	public List<Hospital> selectHospitalByAddr(String addr) throws SQLException{
		List<Hospital> list = patientDAO.selectHospitalByAddr(addr);
		if(list == null) {
			throw new SQLException("�ּҿ� �ش��ϴ� ������ ã�� �� �����ϴ�.");
		}
		return list;
	}
	
	public List<Hospital> selectHospitalAll() throws SQLException{
		List<Hospital> list = patientDAO.selectHospitalAll();
		if(list == null) {
			throw new SQLException("������ �����ϴ�...");
		}
		return list;
	}
	
	/*
	 **Dao�ܿ��� ȯ�� ��� �ڵ��̹Ƿ� �ʿ����
	 * */
	/*public void insertPatient(Patient patient, String sessionId) throws SQLException{
		int result = patientDAO.insertPatient(patient, sessionId);
		if(result==0) {
			throw new SQLException("��Ͽ� �����߽��ϴ�.");
		}
	}*/
	
	public void insertRoute(Route route) throws SQLException{
		int result = patientDAO.insertRoute(route);
		if(result == 0) {
			throw new SQLException("��Ͽ� �����߽��ϴ�. �ùٸ� ����ڵ带 �Է��Ͽ� �ֽʽÿ�");
		}

	}
	
	public Hospital selectHospitalByName(String hospitalName, String sessionId) throws SQLException{
		Hospital hospital = patientDAO.selectHospitalByName(hospitalName, sessionId);
		if(hospital == null) {
			throw new SQLException("ã���ô� ������ ���� ������ �����ϴ�.");
		}
		return hospital;
	}
	
	public List<Place> selectPlaceAll() throws SQLException{
		List<Place>list= new ArrayList<Place>();
		list=patientDAO.selectPlaceAll();
		if(list==null) {
			throw new SQLException("��Ұ� ���� ���� �ʽ��ϴ�");
		}
		return list;
	}
}
