package terry.design.simplefactory;
/**
  
  张全
 */
public class OALoginImpl implements LoginApi {

	@Override
	public void login(String userName, String password) {
	   
       System.out.println("登陆OA系统(账号："+userName+",密码："+password+")");
	}

}
