package covid.mvc.view;

import java.util.Scanner;

import covid.mvc.controller.ClientsController;
import covid.mvc.controller.HospitalController;
import covid.mvc.controller.PatientController;
import covid.mvc.session.Session;
import covid.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			MenuView.printMenu();
			System.out.print("▶▶");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.login();// 로그인
				break;
			case 2:
				MenuView.insertClients(); // 회원가입
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				System.out.println("오늘도 건강한 하루 되세요");
				System.exit(0);
			}
		}

	}

	public static void printMenu() {
		System.out.println("====================================================");
		System.out.println("====================================================");
		System.out.println("======================코로나========================");
		System.out.println("====================================================");
		System.out.println("====================================================");
		System.out.println("----------원하는 메뉴 번호를 눌러 주세요------------");
		System.out.println("------------------1. 로그인하기---------------------");
		System.out.println("------------------2. 회원가입하기-------------------");
		System.out.println("------------------3. 시스템 종료--------------------");
		System.out.println("----------------------------------------------------");
	}

	public static void printClientsMenu(Session session) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("====================================================");
			System.out.println("-----" + session.getSessionId() + "님 반갑습니다^^------");
			System.out.println("우리시 현황 : "+session.getSeoul());
			System.out.println("==============*오늘도 건강한 하루되세요*============");
			System.out.println("====================================================");
			System.out.println("------------원하는 메뉴 번호를 눌러 주세요----------");
			System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶");
			System.out.println("--------------1.우리 동네 마스크 조회---------------");
			System.out.println("----------------2. 확진자 동선 조회-----------------");
			System.out.println("------------3.구 별 확진자 및 위험도 현황-----------");
			System.out.println("----------------------4. 로그아웃-------------------");
			System.out.println("----------------------------------------------------");

			System.out.print("▶▶");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				ClientsController.selectMaskByAddr(session.getSessionAddr());// 마스크수 조회
				break;
			case 2:
				System.out.println(" 어느 주소의 확진자의 동선을 조회하시겠습니까?");
				System.out.println("-------1. 내 주소 기반 확진자 동선 조회-------");
				System.out.println("-----2. 원하는 주소 기반 확진자 동선 조회-----");
				System.out.print("▶▶");
				int sub = Integer.parseInt(sc.nextLine());
				switch (sub) {
				case 1:
					ClientsController.selectRouteByAddr(session.getSessionAddr());
					break;
				case 2:
					System.out.println("조회하실 구를 입력하세요.");
					String addr = sc.nextLine();
					ClientsController.selectRouteByAddr(addr);
					break;
				case 3:
					ClientsController.selectByAll();
					break;
				case 4:
					logout(session.getSessionId());
					return;
				// break;

				}
			}

		}
	}

	public static void printPatientMenu(Session session) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("==============================================================");
			System.out.println("----" + session.getSessionId() + "님의 완치를 간절히 기원합니다---");
			System.out.println("==============================================================");
			System.out.println("------------------원하는 메뉴 번호를 눌러 주세요--------------");
			System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶");
			System.out.println("------------1. 현재 입원 가능한 병원 조회 및 선택-------------");
			System.out.println("------------------2. 나의 동선 입력하기-----------------------");
			System.out.println("-----------------------3. 로그아웃----------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.print("▶▶");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				PatientController.selectHospitalByAddr(session.getSessionAddr());// 내주소기반
				selectHospitalByName(session);
				break;
			case 2:
				System.out.println("방문하신 구를 입력하세요");
				System.out.print("▶▶");
				String district = sc.nextLine();
				System.out.println("방문하신 장소의 코드를 참조하여 입력하세요");
				// 장소코드 보여줄 메소드추가
				System.out.print("▶▶");
				String placeCode = sc.nextLine();
				System.out.println("장소를 방문하신 날짜를 입력하여 주세요(예:2020-08-13)");
				System.out.print("▶▶");
				String visitDate = sc.nextLine();
				PatientController.insertRoute(district, placeCode, session.getSessionId(), visitDate);
				break;
			case 3:
				logout(session.getSessionId());
				return;
			// break;
			}

		}
	}

	public static void printHospitalMenu(Session session) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("==============================================================");
			System.out.println("-------" + session.getSessionId() + "님 오늘도 감사합니다^^-------");
			// 병원이름 보여주기
			System.out.println("==============================================================");
			System.out.println("------------------원하는 메뉴 번호를 눌러 주세요--------------");
			System.out.println("▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶");
			System.out.println("-------------------1. 병원 현황 조회하기----------------------");
			System.out.println("-----------------2. 우리 병원 환자 입원 현황------------------");
			System.out.println("--------------------3. 완치 환자 상태변경---------------------");
			System.out.println("--------------------4. 병원 의료진 수 변경--------------------");
			System.out.println("-----------------------5. 로그아웃----------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.print("▶▶");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				HospitalController.selectHospital(session.getSessionId());

			case 2:
				HospitalController.selectByPatient(session.getSessionId());

			case 3:
				HospitalController.selectByPatient(session.getSessionId());
				System.out.println("완치된 환자의 번호를 입력하세요");
				System.out.print("▶▶");
				int patientNo = Integer.parseInt(sc.nextLine());
				HospitalController.updatePatient(patientNo);

			case 4:
				System.out.println("변경할 의료진 수를 입력하세요");
				System.out.print("▶▶");
				int mediStaff = Integer.parseInt(sc.nextLine());
				HospitalController.updateMediStaff(session.getSessionId(), mediStaff);
				
			case 5 :
				logout(session.getSessionId());
				return;
			// break;
				

			}
		}

	}

	/**
	 * 확진자가 병원 선택하기
	 */
	public static void selectHospitalByName(Session session) {
		System.out.println("병원을 선택하세요");
		System.out.print("▶▶");
		String hospital = sc.nextLine();
		PatientController.selectHospitalByName(hospital, session.getSessionId());
	}

	/**
	 * 로그인하기
	 */
	public static void login() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("비번 : ");
		String userPwd = sc.nextLine();

		ClientsController.login(userId, userPwd);

	}

	/**
	 * 로그아웃하기
	 */
	private static void logout(String userId) {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원가입하기
	 */
	private static void insertClients() {
		
	}
}
