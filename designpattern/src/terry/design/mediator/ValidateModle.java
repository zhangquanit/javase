package terry.design.mediator;
/**
  
  张全

 */
public class ValidateModle {
	
	public boolean validate(){
		System.out.println("..........验证用户");
		Mediator.getInstance().register();//只和中介者交互
		return true;
	}

}
