package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;

public class HospitalDAOImpl implements HospitalDAO {

	@Override
	public Hospital selectHospital(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> selectByPatient(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePatient(int patientNo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMediStaff(int mediStaff) throws SQLException {
		// TODO Auto-generated method stub

	}

}
