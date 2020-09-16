package covid.mvc.view;

import java.util.List;

import covid.mvc.dto.Clients;





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
}













