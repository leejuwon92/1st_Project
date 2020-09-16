package covid.mvc.view;

import java.util.Scanner;

import covid.mvc.controller.ClientsController;
import covid.mvc.controller.HospitalController;
import covid.mvc.controller.PatientController;
import covid.mvc.dto.Clients;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Route;
import covid.mvc.session.Session;
import covid.mvc.session.SessionSet;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			MenuView.printMenu();
			System.out.print("����");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.login();// �α���
				break;
			case 2:
				MenuView.insertClients(); // ȸ������
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�");
				System.out.println("���õ� �ǰ��� �Ϸ� �Ǽ���");
				System.exit(0);
			}
		}

	}

	public static void printMenu() {
		System.out.println("====================================================");
		System.out.println("====================================================");
		System.out.println("======================�ڷγ�========================");
		System.out.println("====================================================");
		System.out.println("====================================================");
		System.out.println("----------���ϴ� �޴� ��ȣ�� ���� �ּ���------------");
		System.out.println("------------------1. �α����ϱ�---------------------");
		System.out.println("------------------2. ȸ�������ϱ�-------------------");
		System.out.println("------------------3. �ý��� ����--------------------");
		System.out.println("----------------------------------------------------");
	}

	public static void printClientsMenu(Session session) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("====================================================");
			System.out.println("-----" + session.getSessionId() + "�� �ݰ����ϴ�^^------");
			System.out.println(session.getSeoul());
			System.out.println("==============*���õ� �ǰ��� �Ϸ�Ǽ���*============");
			System.out.println("====================================================");
			System.out.println("------------���ϴ� �޴� ��ȣ�� ���� �ּ���----------");
			System.out.println("����������������������������������������������������");
			System.out.println("--------------1.�츮 ���� ����ũ ��ȸ---------------");
			System.out.println("----------------2. Ȯ���� ���� ��ȸ-----------------");
			System.out.println("------------3.�� �� Ȯ���� �� ���赵 ��Ȳ-----------");
			System.out.println("----------------------4. �α׾ƿ�-------------------");
			System.out.println("----------------------------------------------------");

			System.out.print("����");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				ClientsController.selectMaskByAddr(session.getSessionAddr());// ����ũ�� ��ȸ
				break;
			case 2:
				System.out.println(" ��� �ּ��� Ȯ������ ������ ��ȸ�Ͻðڽ��ϱ�?");
				System.out.println("-------1. �� �ּ� ��� Ȯ���� ���� ��ȸ-------");
				System.out.println("-----2. ���ϴ� �ּ� ��� Ȯ���� ���� ��ȸ-----");
				System.out.print("����");
				int sub = Integer.parseInt(sc.nextLine());
				switch (sub) {
				case 1:
					ClientsController.selectRouteByAddr(session.getSessionAddr());
					break;
				case 2:
					System.out.println("��ȸ�Ͻ� ���� �Է��ϼ���.");
					String addr = sc.nextLine();
					ClientsController.selectRouteByAddr(addr);
					break;

				}

			case 3:
				ClientsController.selectByAll();
				break;
			case 4:
				logout(session.getSessionId(), session.getSessionAddr(), session.getSessionType());
				return;
			// break;
			}

		}
	}

	public static void printPatientMenu(Session session) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("==============================================================");
			System.out.println("----" + session.getSessionId() + "���� ��ġ�� ������ ����մϴ�---");
			System.out.println("==============================================================");
			System.out.println("------------------���ϴ� �޴� ��ȣ�� ���� �ּ���--------------");
			System.out.println("��������������������������������������������������������������");
			System.out.println("------------1. ���� �Կ� ������ ���� ��ȸ �� ����-------------");
			System.out.println("------------------2. ���� ���� �Է��ϱ�-----------------------");
			System.out.println("-----------------------3. �α׾ƿ�----------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.print("����");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				PatientController.selectHospitalByAddr(session.getSessionAddr());// ���ּұ��
				selectHospitalByName(session);
				break;
			case 2:
				System.out.println("�湮�Ͻ� ���� �Է��ϼ���");
				System.out.print("����");
				String district = sc.nextLine();
				System.out.println("�湮�Ͻ� ����� �ڵ带 �����Ͽ� �Է��ϼ���");
				// ����ڵ� ������ �޼ҵ��߰�
				System.out.print("����");
				String placeCode = sc.nextLine();
				System.out.println("��Ҹ� �湮�Ͻ� ��¥�� �Է��Ͽ� �ּ���(��:2020-08-13)");
				System.out.print("����");
				String visitDate = sc.nextLine();
				Route route = new Route(district, placeCode, session.getSessionId(), 0, visitDate);
				PatientController.insertRoute(route);
				break;
			case 3:
				logout(session.getSessionId(), session.getSessionAddr(), session.getSessionType());
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
			System.out.println("-------" + session.getSessionId() + "�� ���õ� �����մϴ�^^-------");
			// �����̸� �����ֱ�
			System.out.println("==============================================================");
			System.out.println("------------------���ϴ� �޴� ��ȣ�� ���� �ּ���--------------");
			System.out.println("��������������������������������������������������������������");
			System.out.println("-------------------1. ���� ��Ȳ ��ȸ�ϱ�----------------------");
			System.out.println("-----------------2. �츮 ���� ȯ�� �Կ� ��Ȳ------------------");
			System.out.println("--------------------3. ��ġ ȯ�� ���º���---------------------");
			System.out.println("--------------------4. ���� �Ƿ��� �� ����--------------------");
			System.out.println("-----------------------5. �α׾ƿ�----------------------------");
			System.out.println("--------------------------------------------------------------");
			System.out.print("����");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				HospitalController.selectHospital(session.getSessionId());

			case 2:
				HospitalController.selectByPatient(session.getSessionId());

			case 3:
				HospitalController.selectByPatient(session.getSessionId());
				System.out.println("��ġ�� ȯ���� ��ȣ�� �Է��ϼ���");
				System.out.print("����");
				int patientNo = Integer.parseInt(sc.nextLine());
				HospitalController.updatePatient(patientNo);

			case 4:
				System.out.println("������ �Ƿ��� ���� �Է��ϼ���");
				System.out.print("����");
				int mediStaff = Integer.parseInt(sc.nextLine());
				HospitalController.updateMediStaff(session.getSessionId(), mediStaff);

			case 5:
				logout(session.getSessionId(), session.getSessionAddr(), session.getSessionType());
				return;
			// break;

			}
		}

	}

	/**
	 * Ȯ���ڰ� ���� �����ϱ�
	 */
	public static void selectHospitalByName(Session session) {
		System.out.println("������ �����ϼ���");
		System.out.print("����");
		String hospital = sc.nextLine();
		PatientController.selectHospitalByName(hospital, session.getSessionId());
	}

	/**
	 * �α����ϱ�
	 */
	public static void login() {
		System.out.print("���̵� : ");
		String userId = sc.nextLine();

		System.out.print("��� : ");
		String userPwd = sc.nextLine();

		ClientsController.login(userId, userPwd);

	}

	/**
	 * �α׾ƿ��ϱ�
	 */
	private static void logout(String sessionId, String sessionAddr, int sessionType) {
		SessionSet ss = SessionSet.getInstance();
		Session session = new Session(sessionId, null, 0);
		ss.remove(session);
	}

	/**
	 * ȸ�������ϱ�
	 */
	private static void insertClients() {

		System.out.println();
		System.out.print("���̵� : ");
		String userId = sc.nextLine();

		System.out.print("��� : ");
		String userPwd = sc.nextLine();

		System.out.print("����(|| �Ϲ���:1 || ����:2 ||) : ");
		int userType = sc.nextInt();
		if(userType < 3 && userType > 0) {
			if(userType == 2) {
				userType = 3;
			} 
		} else {
			System.out.println("��ȣ �Է� �����Դϴ�.");
			return;
		}
		
		System.out.print("�ּ� : ");
		String userAddr = sc.nextLine();

		Clients client = new Clients(userId, userPwd, userType, userAddr);
		ClientsController.insertClients(client);
		if (userType == 2) {
			insertHospital(userAddr, userId);
		}

	}

	/**
	 * ����ȸ������
	 */
	private static void insertHospital(String addr, String userId) {
		System.out.println();
		System.out.print("���� �ڵ� : ");
		String hospitalCode = sc.nextLine();

		System.out.print("�Ƿ��� �� : ");
		int mediStaff = sc.nextInt();

		System.out.print("���� �̸� : ");
		String hospitalName = sc.nextLine();

		System.out.print("���� �� : ");
		int bedNo = sc.nextInt();

		System.out.print("���� ȯ�� �� : ");
		int patientCurr = sc.nextInt();

		Hospital hospital = new Hospital(hospitalCode, mediStaff, hospitalName, bedNo, addr, patientCurr, userId);
		HospitalController.insertHospital(hospital);

	}
}
