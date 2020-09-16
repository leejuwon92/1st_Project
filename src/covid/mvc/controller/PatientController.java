package covid.mvc.controller;

import covid.mvc.dto.Route;
import covid.mvc.service.PatientService;
import covid.mvc.view.FailView;
import covid.mvc.view.MenuView;
import covid.mvc.view.SuccessView;

public class PatientController {
	private static PatientService service=new PatientService();

	public static void selectHospitalByAddr(String addr) {
		try {
			SuccessView.printHospital(service.selectHospitalByAddr(addr));
			
		}catch(Exception e){
			FailView.errorMessage(e.getMessage());
			selectHospitalAll();
			MenuView.selectHospitalByName(null);
			
		}
	}

	public static void selectHospitalByName(String hospital, String sessionId) {
		try {
			System.out.println("������ ���� �Ǿ����ϴ�.");
			
			service.selectHospitalByName(hospital, sessionId);
			
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
