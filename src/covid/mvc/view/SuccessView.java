package covid.mvc.view;

import java.util.List;

import covid.mvc.dto.Clients;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Place;





public class SuccessView {
	public static void printClients(List<Clients> list) {
		System.out.println("------------------�α��� ���� ---------------");
		
	}
		/**
		 * ����, ����, ��� ���� �޽��� ���
		 * */
		public static void messagePrint(String message) {
			System.out.println(message);
			
		}
		
		/**
		 * �� �ּұ�� ���� ����ϱ�
		 * */
		public static void printHospital(List<Hospital> list) {
			for(Hospital hospital:list) {
				System.out.println(hospital.hospitalHospital());
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













