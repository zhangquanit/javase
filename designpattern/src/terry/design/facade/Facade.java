package terry.design.facade;
/**
  
  张全
  外观类
 */
public class Facade {
	//通常以单例形式
    private static Facade facade=null;
	private  Facade(){}
	public static Facade getInstance(){
		if(facade==null){
			facade=new Facade();
		}
		return facade;
	}
	
	//封装外部对模块A,B的交互过程
	public static void  test(){
		FInterfaceA apiA=new FImplA();
		FInterfaceB apiB=new FImplB();
		apiA.testA();
		apiB.testB();
	}
}
