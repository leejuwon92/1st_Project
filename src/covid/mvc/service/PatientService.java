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
	
	public Hospital selectHospitalByAddr(String userAddr) throws SQLException {
		Hospital hospital = patientDAO.selectHospitalByAddr(userAddr);
		return hospital;
	}
	
	public List<Hospital> selectHospitalAll() throws SQLException {
		List<Hospital> list = patientDAO.selectHospitalAll();
		return list;
	}
	
	public void insertPatient(Patient patient) {
		
	}
	
	public void insertRoute(Route route) {
		
	}
}
