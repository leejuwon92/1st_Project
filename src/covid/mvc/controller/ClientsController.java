package covid.mvc.controller;

import covid.mvc.dto.Clients;
import covid.mvc.service.ClientsService;
import covid.mvc.session.Session;
import covid.mvc.view.FailView;
import covid.mvc.view.MenuView;
import covid.mvc.view.SuccessView;


public class ClientsController {
	private static ClientsService service = new ClientsService();

	public static void login(String userId, String userPwd) {
		try {
			Clients clients = service.login(userId, userPwd);
			Session session=new Session(clients.getUserId(),clients.getUserAddr(),clients.getUserType());
			if(session.getSessionType()==1) {
				MenuView.printClientsMenu(session);
			}
			if(session.getSessionType()==2) {
				MenuView.printPatientMenu(session);
			}
			if(session.getSessionType()==3) {
				MenuView.printHospitalMenu(session);
			}
		} catch (Exception e) {
			//FailView.errorMessage(e.getMessage());

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
			SuccessView.printRoute(service.selectRouteByAddr(addr));
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
	
	

}
