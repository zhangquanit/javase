package terry.design.strategy;
/**
  
  张全
把日志记录到文件中
 */
public class FileLog extends LogStrategyTemplate {

	@Override
	public void doLog(String msg) {
	
     System.out.println("现在把\""+msg+"\"记录到文件中");
	}

}
