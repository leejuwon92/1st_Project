package covid.mvc.controller;

import java.util.List;

import covid.mvc.dao.ClientsDAOImpl;
import covid.mvc.dto.Clients;
import covid.mvc.dto.Route;
import covid.mvc.dto.Seoul;
import covid.mvc.service.ClientsService;
import covid.mvc.session.Session;
import covid.mvc.view.FailView;
import covid.mvc.view.MenuView;
import covid.mvc.view.SuccessView;


public class ClientsController {
	private static ClientsService service = new ClientsService();
	private static ClientsDAOImpl dao = new ClientsDAOImpl();

	public static void login(String userId, String userPwd) {
		try {
			Clients clients = service.login(userId, userPwd);
			Session session=new Session(clients.getUserId(),clients.getUserAddr(),clients.getUserType());
			
			if(session.getSessionType()==1) {
				Seoul seoul = service.selectSeoulByAddr(session.getSessionAddr());
				session.setSeoul(seoul);
				MenuView.printClientsMenu(session);
			}
			if(session.getSessionType()==2) {
				Seoul seoul = service.selectSeoulByAddr(session.getSessionAddr());
				session.setSeoul(seoul);
				MenuView.printPatientMenu(session);
			}
			if(session.getSessionType()==3) {
				MenuView.printHospitalMenu(session);
			}
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}
	public static void selectMaskByAddr(String addr){
		try {
			SuccessView.printDrug(service.selectMaskByAddr(addr));
			}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectRouteByAddr(String addr) {
		try {
			System.out.println("controller  "+addr);
			List<Route> list = service.selectRouteByAddr(addr);
			SuccessView.printRoute(list);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void selectByAll() {
		try {
			SuccessView.printSeoul(service.selectByAll());
			
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void insertClients(Clients clients) {
		try {
			service.insertClients(clients);
			SuccessView.messagePrint("회원가입 성공.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}
