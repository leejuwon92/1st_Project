package covid.mvc.view;

import java.util.Scanner;

import covid.mvc.controller.ClientsController;
import covid.mvc.controller.HospitalController;
import covid.mvc.controller.PatientController;
import covid.mvc.dto.Clients;
import covid.mvc.dto.Hospital;
import covid.mvc.dto.Patient;
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
					System.out.println(addr);
					ClientsController.selectRouteByAddr(addr);
					break;

				}
				break;
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

				PatientController.selectPlaceAll();
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
				break;

			case 2:
				HospitalController.selectByPatient(session.getSessionId());
				break;

			case 3:
				HospitalController.selectByPatient(session.getSessionId());
				System.out.println("��ġ�� ȯ���� ��ȣ�� �Է��ϼ���");
				System.out.print("����");
				int patientNo = Integer.parseInt(sc.nextLine());
				HospitalController.updatePatient(patientNo);
				break;

			case 4:
				System.out.println("������ �Ƿ��� ���� �Է��ϼ���");
				System.out.print("����");
				int mediStaff = Integer.parseInt(sc.nextLine());
				HospitalController.updateMediStaff(session.getSessionId(), mediStaff);
				break;

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
		while (true) {
			System.out.println();
			System.out.print("���̵� : ");
			String userId = sc.nextLine();

			System.out.print("��� : ");
			String userPwd = sc.nextLine();

			System.out.print("����(|| �Ϲ���:1 || Ȯ����:2 || ����:3 ||) : ");
			int userType = Integer.parseInt(sc.nextLine());
			if (userType < 4 && userType > 0) {

				System.out.print("�ּ� : ");
				String userAddr = sc.nextLine();

				System.out.println("ID : " + userId);
				System.out.println("Password : " + userPwd);
				System.out.println("Address : " + userAddr);
				if (userType == 1)
					System.out.println("userType : �Ϲ���");
				else if (userType == 2)
					System.out.println("userType : Ȯ����");
				else if (userType == 3)
					System.out.println("userType : ����");
				while (true) {
					System.out.println("�Է��Ͻ� ������ �½��ϱ�?");
					System.out.println("   Y ȸ������    /   N ȸ������ ������  ");
					System.out.print(" >> ");
					String confirm = sc.nextLine();
					if (confirm.equals("y")) {
						Clients client = new Clients(userId, userPwd, userType, userAddr);
						System.out.println(client.getUserAddr());
						ClientsController.insertClients(client);
						
						if (userType == 3) {
							insertHospital(userAddr, userId);
							return;
						}
					} else if (confirm.equals("n")) {
						return;
					} else {
						System.out.println("Y Ȥ�� N���θ� �Է����ּ���");
					}

				}
			} else {
				System.out.println("��ȣ �Է� �����Դϴ�.");
			}
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
		int mediStaff = Integer.parseInt(sc.nextLine());

		System.out.print("���� �̸� : ");
		String hospitalName = sc.nextLine();


		Hospital hospital = new Hospital(hospitalCode, mediStaff, hospitalName, 0, addr, 0, userId);
		HospitalController.insertHospital(hospital);

	}
}
