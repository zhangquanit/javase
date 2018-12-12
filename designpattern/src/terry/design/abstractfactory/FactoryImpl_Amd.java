package terry.design.abstractfactory;
/**
  
  张全
产品簇的实现:Amd
  负责生产AMD的cpu和mainboard
 */
public class FactoryImpl_Amd implements AbstractFactory {

	@Override
	public CPUApi createCpu() {
		return new CPUApi_Amd();
	}

	@Override
	public MainBoardApi createMainBoard() {
		return new MainBoardApi_Amd();
	}

}
