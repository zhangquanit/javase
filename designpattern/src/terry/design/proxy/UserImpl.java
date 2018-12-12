package terry.design.proxy;
/**
  
  张全
 具体的目标对象/被代理的对象
 */
public class UserImpl implements UserApi {

	@Override
	public void setUserName(String username) {
     System.out.println("username=="+username);
	}

	@Override
	public void setAge() {

	}

}
