package covid.mvc.service;

import covid.mvc.dao.PatientDAO;
import covid.mvc.dao.PatientDAOImpl;

public class PatientService {
	PatientDAO patientDAO = new PatientDAOImpl();
}
