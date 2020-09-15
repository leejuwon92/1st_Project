package covid.mvc.service;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dao.PatientDAO;
import covid.mvc.dao.PatientDAOImpl;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Route;

public class PatientService {
	PatientDAO patientDAO = new PatientDAOImpl();
	
	public Hospital selectHospitalByAddr(String addr) throws SQLException{
		Hospital hospital = patientDAO.selectHospitalByAddr(addr);
		if(hospital == null) {
			throw new SQLException("�ּҿ� �ش��ϴ� ������ ã�� �� �����ϴ�.");
		}
		return hospital;
	}
	
	public List<Hospital> selectHospitalAll() throws SQLException{
		List<Hospital> list = patientDAO.selectHospitalAll();
		if(list == null) {
			throw new SQLException("������ �����ϴ�...");
		}
		return list;
	}
	
	public void insertPatient(Patient patient) throws SQLException{
		int result = patientDAO.insertPatient(patient);
		if(result==0) {
			throw new SQLException("��Ͽ� �����߽��ϴ�.");
		}
	}
	
	public void insertRoute(Route route) throws SQLException{
		int result = patientDAO.insertRoute(route);
		if(result == 0) {
			throw new SQLException("��Ͽ� �����߽��ϴ�");
		}

	}
}
