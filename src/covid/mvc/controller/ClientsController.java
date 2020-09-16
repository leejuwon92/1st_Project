package covid.mvc.controller;

import covid.mvc.dao.ClientsDAOImpl;
import covid.mvc.dto.Clients;
import covid.mvc.dto.Seoul;
import covid.mvc.service.ClientsService;
import covid.mvc.session.Session;
import covid.mvc.view.MenuView;


public class ClientsController {
	private static ClientsService service = new ClientsService();
	private static ClientsDAOImpl dao = new ClientsDAOImpl();

	public static void login(String userId, String userPwd) {
		try {
			Clients clients = service.login(userId, userPwd);
			Session session=new Session(clients.getUserId(),clients.getUserAddr(),clients.getUserType());
//			Seoul seoul = dao.selectSeoulByAddr(session.getSessionAddr());
//			session.setSeoul(seoul);
//			임시 서울 가져오기 
//			컨트롤러가 완성되면 dao 객체 생성 코드랑 함께 지워주세요
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

}
