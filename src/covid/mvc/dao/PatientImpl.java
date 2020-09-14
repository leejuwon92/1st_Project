package covid.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Route;

public class PatientImpl implements PatientDAO {

	@Override
	public Hospital selectHospitalByAddr(String userAddr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> selectHospitalAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPatient(Patient patient) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRoute(Route route) throws SQLException {
		// TODO Auto-generated method stub

	}

}
