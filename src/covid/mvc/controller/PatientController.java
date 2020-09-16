package covid.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import covid.mvc.dto.Hospital;
import covid.mvc.dto.Route;
import covid.mvc.service.PatientService;
import covid.mvc.view.FailView;
import covid.mvc.view.SuccessView;

public class PatientController {
	private static PatientService service=new PatientService();

	public static void selectHospitalByAddr(String addr) {
		try {
			List<Hospital> list = service.selectHospitalByAddr(addr);
			SuccessView.printHospital(list);
			
		}catch(Exception e){
			FailView.errorMessage(e.getMessage());
			List<Hospital> list;
			try {
				list = service.selectHospitalAll();
				SuccessView.printHospital(list);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void selectHospitalByName(String hospital, String sessionId) {
		try {
			service.selectHospitalByName(hospital, sessionId);
			System.out.println("������ ���� �Ǿ����ϴ�.");
		}catch(Exception e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	
	public static void selectHospitalAll() {
		try {
			SuccessView.printHospital(service.selectHospitalAll());
			
		}catch(Exception e ) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void insertRoute(Route route) {
		try {
			service.insertRoute(route);
			SuccessView.messagePrint("������ ���������� �ԷµǾ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		
	}

	public static void selectPlaceAll() {
		try{
			SuccessView.printPlace(service.selectPlaceAll());
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
}
