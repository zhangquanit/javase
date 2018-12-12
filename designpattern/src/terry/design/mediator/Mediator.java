package terry.design.mediator;
/**
  
  张全

封装各个同事类之间的交互
 */
public class Mediator {
   private static Mediator mediator=null;//通常实现为单例
   public static Mediator getInstance(){
	   if(mediator==null){
		   mediator=new Mediator();
	   }
	   return mediator;
   }
   public void register(){
	   new RegisterModle().register();
   }
   public void login(){
	   new LoginModle().login();
   }
}
