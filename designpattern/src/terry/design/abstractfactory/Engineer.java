package terry.design.abstractfactory;

/**
 * 张全
 * 
 * 装机工厂师：负责根据用户的请求提供装机方案，并实现装机
 */
public class Engineer {
	public CPUApi cpuApi;
	public MainBoardApi mainBoardApi;

   /**
    * 装机过程
    * @param factory 客户选择的装机方案
    */
	public void makeComputer(AbstractFactory factory) {
		//1.首先准备好装机所需要的配件
		prepareHardware(factory);
		
		//2.组装电脑
		//3.测试电脑
		//4.交付客户
		
		
	}
	/**
	 * 准备装机所需要的配件
	 * @param factory 客户选择的装机方案
	 */
	private void prepareHardware(AbstractFactory factory){
		//使用抽象工厂类获取相应的接口对象  面向接口编程
		this.cpuApi = factory.createCpu();
		this.mainBoardApi = factory.createMainBoard();
		//测试一下配件是否好用
		this.cpuApi.run();
		this.mainBoardApi.installCpu();
	}
}
