package covid.mvc.view;

import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Drug;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
import covid.mvc.dto.Place;
import covid.mvc.dto.Route;
import covid.mvc.dto.Seoul;


public class SuccessView {
	public static void Clients(){
		System.out.println("------------------�α��� ���� ---------------");

	}


	/**
	 * ����, ����, ��� ���� �޽��� ���
	 */
	public static void messagePrint(String message) {
		System.out.println(message);

	}

	// Controller(Clients, Hospital,Patient���� ��ɵ� Ŭ���Ҷ� �Ʒ� �޼���� ����)
	// ����ũ ��ȸ
	public static void printDrug(List<Drug> list) {
		for (Drug drug : list) {
			System.out.println(drug);
		}
	}

	// Ȯ���ڵ���
	public static void printRoute(List<Route> list) {
		for (Route route : list) {
			System.out.println(route);
		}
	}

	// Ȯ���� ��Ȳ
	public static void printSeoul(List<Seoul> list) {
		for (Seoul seoul : list) {
			System.out.println(seoul);
		}

	}

	// Hospital
	// ���� ������ȸ
	public static void printHospital(Hospital hospital) {
		System.out.println(hospital.hospitalHospital());

	}

	// ���� ȯ�� ��ȸ
	public static void printCurrentPatient(List<Patient> list) {
		for(Patient patient:list) {
			System.out.println(patient);
			}
		}

	/**
	 * �� �ּұ�� ���� ����ϱ�
	 */
	public static void printHospital(List<Hospital> list) {
		for (Hospital hospital : list) {
			System.out.println(hospital.patientHospital());
		}
	}

	/**
	* �Է��Ҷ� ������ ����ڵ� ����ϱ�
		 * */
		public static void printPlace(List<Place> list) {
			for(Place place:list) {
				System.out.println(place);
			}
		}
}