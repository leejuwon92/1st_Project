  
package covid.mvc.controller;

import java.sql.SQLException;

import covid.mvc.dto.Hospital;
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
			service.updatePatient(patientNo);
			SuccessView.messagePrint("ȯ�� ���°� ����Ǿ����ϴ�");
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void updateMediStaff(String userId,int mediStaff) {
		try {
			service.updateMediStaff(userId, mediStaff);

			SuccessView.messagePrint("�Ƿ��� ���°� ����Ǿ����ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void insertHospital(Hospital hospital) {
		try {
			service.insertHospital(hospital);
			SuccessView.messagePrint("����ȸ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}
