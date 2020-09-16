package covid.mvc.controller;

import covid.mvc.service.HospitalService;
import covid.mvc.view.FailView;
import covid.mvc.view.SuccessView;

public class HospitalController {
	private static HospitalService service=new HospitalService();

	public static void selectHospital(String userId) {
		try {
			SuccessView.printHospital(service.selectHospital(userId));
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectByPatient(String userId) {
		try {
			SuccessView.printCurrentPatient(service.selectByPatient(userId));
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void updatePatient(int patientNo) {
		try {
			SuccessView.messagePrint("ȯ�� ���°� ����Ǿ����ϴ�");
			service.updatePatient(patientNo);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void updateMediStaff(String userId,int mediStaff) {
		try {
			SuccessView.messagePrint("�Ƿ��� ���°� ����Ǿ����ϴ�.");
			service.updateMediStaff(userId, mediStaff);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}
