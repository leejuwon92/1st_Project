package covid.mvc.service;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dao.HospitalDAO;
import covid.mvc.dao.HospitalDAOImpl;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;

public class HospitalService {
	HospitalDAO hospitalDAO = new HospitalDAOImpl();
	
	public Hospital selectHospital(String userId) throws SQLException {
		Hospital hospital = hospitalDAO.selectHospital(userId);
		return hospital;
	}
	
	public List<Patient> selectByPatient(String userId) throws SQLException {
		List<Patient> list = hospitalDAO.selectByPatient(userId);
		return list;
	}
	
	public void updatePatient(int patientNo) throws SQLException {
		int result = hospitalDAO.updatePatient(patientNo);
		if(result == 0) throw new SQLException(patientNo + " 번 환자가 존재하지 않습니다.");
	}
	
	public void updateMediStaff(String userId, int mediStaff) throws SQLException {
		int result = hospitalDAO.updateMediStaff(userId, mediStaff);
		if(result == 0) throw new SQLException(mediStaff + " 명으로 수정되지 않았습니다.");
	}
}
