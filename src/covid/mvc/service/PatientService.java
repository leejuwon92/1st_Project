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
			throw new SQLException("주소에 해당하는 병원을 찾을 수 없습니다.");
		}
		return list;
	}
	
	public List<Hospital> selectHospitalAll() throws SQLException{
		List<Hospital> list = patientDAO.selectHospitalAll();
		if(list == null) {
			throw new SQLException("병원이 없습니다...");
		}
		return list;
	}
	
	/*
	 **Dao단에서 환자 등록 자동이므로 필요없음
	 * */
	/*public void insertPatient(Patient patient, String sessionId) throws SQLException{
		int result = patientDAO.insertPatient(patient, sessionId);
		if(result==0) {
			throw new SQLException("등록에 실패했습니다.");
		}
	}*/
	
	public void insertRoute(Route route) throws SQLException{
		int result = patientDAO.insertRoute(route);
		if(result == 0) {
			throw new SQLException("등록에 실패했습니다. 올바른 장소코드를 입력하여 주십시오");
		}

	}
	
	public Hospital selectHospitalByName(String hospitalName, String sessionId) throws SQLException{
		Hospital hospital = patientDAO.selectHospitalByName(hospitalName, sessionId);
		if(hospital == null) {
			throw new SQLException("찾으시는 병원에 대한 정보가 없습니다.");
		}
		return hospital;
	}
	
	public List<Place> selectPlaceAll() throws SQLException{
		List<Place>list= new ArrayList<Place>();
		list=patientDAO.selectPlaceAll();
		if(list==null) {
			throw new SQLException("장소가 존재 하지 않습니다");
		}
		return list;
	}
}
