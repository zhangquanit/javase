package terry.design.abstractfactory;
/**
  
  张全

抽象工厂通常为一个接口
 */
public interface AbstractFactory {

	public CPUApi  createCpu();
	public MainBoardApi createMainBoard();
}
