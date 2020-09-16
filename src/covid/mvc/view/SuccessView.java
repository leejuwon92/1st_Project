package covid.mvc.view;

import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Place;





public class SuccessView {
	public static void printClients(List<Clients> list) {
		System.out.println("------------------로그인 성공 ---------------");
		
	}
		/**
		 * 수정, 삭제, 등록 성공 메시지 출력
		 * */
		public static void messagePrint(String message) {
			System.out.println(message);
			
		}
		
		/**
		 * 내 주소기반 병원 출력하기
		 * */
		public static void printHospital(List<Hospital> list) {
			for(Hospital hospital:list) {
				System.out.println(hospital.hospitalHospital());
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













