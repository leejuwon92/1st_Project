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
		System.out.println("------------------로그인 성공 ---------------");

	}


	/**
	 * 수정, 삭제, 등록 성공 메시지 출력
	 */
	public static void messagePrint(String message) {
		System.out.println(message);

	}

	// Controller(Clients, Hospital,Patient에서 기능들 클릭할때 아래 메서드들 동작)
	// 마스크 조회
	public static void printDrug(List<Drug> list) {
		for (Drug drug : list) {
			System.out.println(drug);
		}
	}

	// 확진자동선
	public static void printRoute(List<Route> list) {
		for (Route route : list) {
			System.out.println(route);
		}
	}

	// 확진자 현황
	public static void printSeoul(List<Seoul> list) {
		for (Seoul seoul : list) {
			System.out.println(seoul);
		}

	}

	// Hospital
	// 현재 병원조회
	public static void printHospital(Hospital hospital) {
		System.out.println(hospital.hospitalHospital());

	}

	// 현재 환자 조회
	public static void printCurrentPatient(List<Patient> list) {
		for(Patient patient:list) {
			System.out.println(patient);
			}
		}

	/**
	 * 내 주소기반 병원 출력하기
	 */
	public static void printHospital(List<Hospital> list) {
		for (Hospital hospital : list) {
			System.out.println(hospital.patientHospital());
		}
	}

	/**
	* 입력할때 참조할 장소코드 출력하기
		 * */
		public static void printPlace(List<Place> list) {
			for(Place place:list) {
				System.out.println(place);
			}
		}
}