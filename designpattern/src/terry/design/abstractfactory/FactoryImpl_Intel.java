package terry.design.abstractfactory;
/**
  
  张全
产品簇的实现:Intel
  负责生产Intel的cpu和mainboard
 */
public class FactoryImpl_Intel implements AbstractFactory {

	@Override
	public CPUApi createCpu() {
		return new CPUApi_Intel();
	}

	@Override
	public MainBoardApi createMainBoard() {
		return new MainBoardApi_Intel();
	}

}
