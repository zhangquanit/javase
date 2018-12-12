package terry.design.simplefactory;
/**
  
  张全
 */
public class SSLoginImpl implements LoginApi {

	@Override
	public void login(String userName, String password) {
      System.out.println("SSL 单点登陆系统(账号："+userName+",密码："+password+")");
	}

}
