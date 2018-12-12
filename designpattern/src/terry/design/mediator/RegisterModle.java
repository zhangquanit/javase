package terry.design.mediator;
/**
  
  张全

 */
public class RegisterModle {
	public boolean register(){
		System.out.println("...........注册用户");
		
		Mediator.getInstance().login();//只和中介者交互
		return true;
	}

}
